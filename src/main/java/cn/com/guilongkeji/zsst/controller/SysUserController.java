package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.SysResource;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import cn.com.guilongkeji.zsst.service.SysResourceService;
import cn.com.guilongkeji.zsst.service.SysUserService;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
@Controller
@RequestMapping("admin")
public class SysUserController {
    @Resource
    private UserService userService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysResourceService sysResourceService;
    private StringBuffer message=new StringBuffer("");
    @PostMapping("/login")
    @ResponseBody
    public Result loginByUser(String username,String password,boolean rememberMe){
        System.out.println(username+password+rememberMe);
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
    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }
    @RequestMapping("/index")
    public String index(Model model){
        Subject subject = SecurityUtils.getSubject();
        List<SysResource> sysResourceList = null;
        String[] roleId = {"2","3","5","6","7"};
        if (subject.hasRole("")){
            //SysRole sysRole =
            sysResourceList = sysResourceService.getSysResourceByAll(StringUtils.StringToList("111"));
        }else if (subject.hasRole(roleId[1])){

        }else if (subject.hasRole(roleId[2])){

        }else if (subject.hasRole(roleId[3])){

        }else if (subject.hasRole(roleId[4])){

        }else {
            return "";
        }
        SysUser sysUser = userService.getUserByName(subject.getPrincipal().toString());
        model.addAttribute("username",sysUser.getUsername());
        return "admin/admin/index";
    }
    @ResponseBody
    @PostMapping("/register")
    public Result registerByUser(@RequestBody SysUser sysUser){
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
    @RequestMapping("welcome")
    public String welcome(){
        return "admin/welcome";
    }
    /**
     * 功能描述 会员管理
     * @author xgl
     * @date 2020/2/4
      * @param
     * @return cn.com.guilongkeji.zsst.result.Result
     */
    @RequestMapping("vipGet")
    @ResponseBody
    public Result vipGet(){
        List<Integer> userIdList = sysUserService.getUserByDetail();
        List<SysUser> userList = sysUserService.getAllSysUserByIds(userIdList);
        return ResultFactory.buildSuccessResult(userList);
    }
    /**
     * 功能描述 会员详情
     * @author xgl
     * @date 2020/2/4
     * @param id
     * @return cn.com.guilongkeji.zsst.result.Result
     */
    @RequestMapping("vipGetAll")
    @ResponseBody
    public Result vipGetAll(Integer id){
        UserDetail userDetail = userService.getUserDetailByUserId(id);
        return ResultFactory.buildSuccessResult(userDetail);
    }

    @RequestMapping("regUser")
    @ResponseBody
    public Result regUser(){
        List<SysUser> userList = sysUserService.getUserByRolesOne();
        return ResultFactory.buildSuccessResult(userList);
    }
    public Result getRole(){

        return ResultFactory.buildSuccessResult("");
    }

    /**
     * 功能描述 文件管理
     * @author xgl
     * @date 2020/2/18
      * @param
     * @return java.lang.String
     */
    public String fileSystemControl(){
        return "";
    }
}
