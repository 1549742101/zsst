package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import cn.com.guilongkeji.zsst.service.ActiveService;
import cn.com.guilongkeji.zsst.service.ImgService;
import cn.com.guilongkeji.zsst.service.ShopService;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.ReCode;
import cn.com.guilongkeji.zsst.utils.TencentSms;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/4
 */
@Controller
@RequestMapping("/app")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ImgService imgService;
    @Resource
    private ActiveService activeService;
    @Resource
    private ShopService shopService;
    private StringBuffer message=new StringBuffer("");
    @ResponseBody
    @PostMapping("/login")
    public Result loginByUser(String username,String password,boolean rememberMe,Model model){
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password,rememberMe);
        try {
            subject.login(usernamePasswordToken);
            SysUser user = userService.getUserByName(username);
            if (!user.getBLocked()) {
                message = new StringBuffer("该用户已被禁用");
                return ResultFactory.buildFailResult(message.toString());
            }
            // 生成随机 token 并存储在 session 中
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            message = new StringBuffer("账号或密码错误");
            return ResultFactory.buildFailResult(message.toString());
        }
    }
    @ResponseBody
    @PostMapping("/register")
    public Result registerByUser(String username,String password,String phone,Model model){
        username = HtmlUtils.htmlEscape(username);
        phone = HtmlUtils.htmlEscape(phone);
        Subject subject = SecurityUtils.getSubject();
        if (StringUtils.isBlank(username) ||StringUtils.isBlank(password)||StringUtils.isBlank(phone)){
            message=username.equals("")?new StringBuffer("用户名为空"):
                    password.equals("")?new StringBuffer("" +
                            "密码为空"):new StringBuffer("" +
                            "手机号为空");
            return ResultFactory.buildFailResult(message.toString());
        }
        if (userService.isExist(username)){
            message=new StringBuffer("用户名已经被使用");
            return ResultFactory.buildFailResult(message.toString());
        }
        SysUser sysUser = new SysUser();
        sysUser.setPhone(phone);
        sysUser.setPassword(password);
        sysUser.setUsername(username);
        try {
            userService.registerSysUser(sysUser);
            message = new StringBuffer("注册成功");
            loginByUser(username,password,false,model);
            System.out.println(message.toString());
            return ResultFactory.buildResult(200,message.toString(),sysUser);
        }catch (Exception e){
            message = new StringBuffer("注册失败，请稍后重试");
            System.out.println(message.toString());
            return ResultFactory.buildFailResult(message.toString());
        }
    }
    @RequestMapping("/loginOut")
    public String loginOut(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("登出成功");
        return getIndex(model);
    }

    @RequestMapping("/index")
    public String getIndex(Model model){
        Subject subject = SecurityUtils.getSubject();
        HashMap<String,String> menuUrl=null;
        List<Img> IndexImg = imgService.getImgByUrl("index");

        String username = null;
        if (subject.isAuthenticated()){
            menuUrl = new HashMap<>(5);
            menuUrl.put("首页","index");
            menuUrl.put("觅食","findDish");
            SysUser sysUser = userService.getUserByName(subject.getPrincipal().toString());
            if (userService.getUserDetailByUserId(sysUser.getId())!=null){
                menuUrl.put("我的","myCount");
                menuUrl.put("购物车","myCart");
            }else {
                menuUrl.put("我的","auth");
                menuUrl.put("购物车","auth");
            }
            username = sysUser.getUsername();
        }else {
            menuUrl = new HashMap<>(5);
            menuUrl.put("首页","index");
            menuUrl.put("觅食","/common/found");
            menuUrl.put("我的","/common/found");
            menuUrl.put("购物车","/common/found");
        }
        model.addAttribute("shop",shopService.getHotsShop());
        model.addAttribute("username",username);
        model.addAttribute("menuUrl",menuUrl);
        model.addAttribute("banner",IndexImg);
        model.addAttribute("active",activeService.getHotsActive());
        return "app/index";
    }

    @ResponseBody
    @PostMapping("/setCode")
    public Result setCode(String phone,String code){
        Code code1 = userService.getCodeByPhone(phone);
        if (code1==null){
            return ResultFactory.buildFailResult("手机号错误");
        }else {
            return code1.getCode().equals(code)?ResultFactory.buildResult(200,"验证码输入正确",null):ResultFactory.buildFailResult("验证码错误");
        }
    }
    @ResponseBody
    @PostMapping("/getCode")
    public Result getCode(String phone){
        Code code = new Code();
        code.setPhone(phone);
        code.setCode(TencentSms.random());
        try {
            userService.insertCode(code);
            TencentSms.send(code);
        }catch (Exception e){
            return ResultFactory.buildFailResult("发送失败");
        }
        return ResultFactory.buildResult(200,"发送成功",null);
    }

    @PostMapping("/getReCode")
    @ResponseBody
    public String getReCode(){
        return new ReCode().getCode();
    }
    @PostMapping("/setReCode")
    @ResponseBody
    public Result setRecode(String code,String recode){
        ReCode reCode = new ReCode();
        if (reCode.isCode(code,recode)){
            return ResultFactory.buildSuccessResult(200);
        }else {
            return ResultFactory.buildFailResult("验证码错误");
        }
    }
    @GetMapping("/found")
    public String found(){
        return "/main/resources/templates/common/found.html";
    }
}
