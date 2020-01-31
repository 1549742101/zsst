package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.dto.MainDto;
import cn.com.guilongkeji.zsst.mapper.UserDetailMapper;
import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import cn.com.guilongkeji.zsst.service.MainService;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.TencentSms;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/4
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private MainService mainService;
    private StringBuffer message=new StringBuffer("");
    @ResponseBody
    @PostMapping("/login")
    public Result LoginByUser(@RequestBody SysUser sysUser){
        String username = sysUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,sysUser.getPassword());
        try {
            SysUser user = userService.getUserByName(username);
            if (!user.getBLocked()) {
                message = new StringBuffer("该用户已被禁用");
                return ResultFactory.buildFailResult(message.toString());
            }
            subject.login(usernamePasswordToken);
            // 生成随机 token 并存储在 session 中
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            message = new StringBuffer("账号或密码错误");
            return ResultFactory.buildFailResult(message.toString());
        }
    }

    @ResponseBody
    @PostMapping("/register")
    public Result RegisterByUser(@RequestBody SysUser sysUser){
        String username = sysUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        if (userService.isExist(username)){
            message=new StringBuffer("用户名已经被使用");
            return ResultFactory.buildFailResult(message.toString());
        }
        sysUser.setUsername(username);
        try {
            userService.registerSysUser(sysUser);
            message = new StringBuffer("注册成功");
            return ResultFactory.buildResult(200,message.toString(),sysUser);
        }catch (Exception e){
            message = new StringBuffer("注册失败，请稍后重试");
            return ResultFactory.buildFailResult(message.toString());
        }
    }
    @RequestMapping("/loginOut")
    public Result LoginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        message = new StringBuffer("成功登出");
        return ResultFactory.buildSuccessResult(message);
    }

    @ResponseBody
    @PostMapping("/index")
    public MainDto getIndex(){
        MainDto mainDto = new MainDto();
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        mainDto.setImgList(mainService.getImgByAllId(list));

        return mainDto;
    }

    @ResponseBody
    @PostMapping("setCode")
    public Result setCode(String phone,String code){
        Code code1 = userService.getCodeByPhone(phone);
        if (code1==null){
            return ResultFactory.buildFailResult("手机号错误");
        }else {
            return code1.getCode().equals(code)?ResultFactory.buildResult(200,"验证码输入正确",null):ResultFactory.buildFailResult("验证码错误");
        }
    }
    @ResponseBody
    @PostMapping("getCode")
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
}
