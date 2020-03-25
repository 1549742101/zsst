package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.dto.ResourceDto;
import cn.com.guilongkeji.zsst.dto.UserDto;
import cn.com.guilongkeji.zsst.pojo.Resource;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import cn.com.guilongkeji.zsst.service.ResourceService;
import cn.com.guilongkeji.zsst.service.RoleService;
import cn.com.guilongkeji.zsst.service.SysUserService;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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
    @javax.annotation.Resource
    private UserService userService;
    @javax.annotation.Resource
    private SysUserService sysUserService;
    @javax.annotation.Resource
    private RoleService roleService;
    @javax.annotation.Resource
    private ResourceService resourceService;
    private StringBuffer message=new StringBuffer("");
    @PostMapping("/login")
    @ResponseBody
    public Result loginByUser(String username,String password,boolean rememberMe){
        System.out.println(username+password+rememberMe);
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        usernamePasswordToken.setRememberMe(rememberMe);
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
        if (!subject.isAuthenticated()){
            return login();
        }
        SysUser sysUser = userService.getUserByName(subject.getPrincipal().toString());
        HashMap<Integer,List<Resource>> result = roleService.getResourceByRole();
        List<SysRole> sysRoleList = roleService.getRoleByAll(StringUtils.StringToList(sysUser.getRoleIds()));
        List<Resource> list = new ArrayList<>();
        for (SysRole sysRole:sysRoleList) {
            if (StringUtils.isNotEmpty(sysRole.getResourceIds())){
                list.addAll(result.get(sysRole.getId()));
            }
        }
        list=list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Resource::getId))), ArrayList::new)
        );
        List<ResourceDto> myMenu = resourceService.getResourceDto(list);
        model.addAttribute("menu",myMenu);
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
     * @param model 传参
     * @param pageNum 页码
     * @param phone 手机号
     * @param id 用户编号
     * @param username 用户名
     * @param name 用户真实姓名
     * @return
     */
    @RequestMapping("vipGet")
    public String vipGet(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=true,defaultValue="")String phone,@RequestParam(required=true,defaultValue="-1")Integer id,@RequestParam(required=true,defaultValue="")String username,@RequestParam(required=true,defaultValue="")String name){
        List<UserDto> userList = sysUserService.getAllUser();
        PageHelper.startPage(pageNum,5);
        if (!id.equals(-1)){
            UserDto userDto1 =  null;
            for (UserDto userDto:userList
            ) {
                if (userDto.getSysUser().getId().equals(id)){
                    userDto1=userDto;
                    userList.clear();
                    break;
                }
            }
            userList.clear();
            if (userDto1!=null){
                userList.add(userDto1);
            }
        }
        if (StringUtils.isBlank(phone)){
            List<UserDto> search = new ArrayList<>();
            for (UserDto userDto:userList
            ) {
                if (StringUtils.contains(userDto.getSysUser().getPhone(),phone)){
                    search.add(userDto);
                }
            }
            userList.clear();
            userList.addAll(search);
        }
        if (StringUtils.isBlank(username)){
            List<UserDto> search = new ArrayList<>();
            for (UserDto userDto:userList
            ) {
                if (StringUtils.contains(userDto.getSysUser().getUsername(),username)){
                    search.add(userDto);
                }
            }
            userList.clear();
            userList.addAll(search);
        }
        if (StringUtils.isBlank(name)){
            List<UserDto> search = new ArrayList<>();
            for (UserDto userDto:userList
            ) {
                if (StringUtils.contains(userDto.getUserDetail().getName(),name)){
                    search.add(userDto);
                }
            }
            userList.clear();
            userList.addAll(search);
        }
        PageInfo<UserDto> pageInfo = new PageInfo<>(userList);
        model.addAttribute("userList",userList);
        model.addAttribute("page",pageInfo);
        return "admin/admin/vip";
    }
    /**
     * 功能描述 会员详情
     * @author xgl
     * @date 2020/2/4
     * @param id 编号
     * @return cn.com.guilongkeji.zsst.result.Result
     */
    @RequestMapping("vipGetAll")
    public Result vipGetAll(Integer id){
        UserDetail userDetail = userService.getUserDetailByUserId(id);
        return ResultFactory.buildSuccessResult(userDetail);
    }

    @RequestMapping("getAllUser")
    public String regUser(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=true,defaultValue="")String phone,@RequestParam(required=true,defaultValue="-1")Integer id,@RequestParam(required=true,defaultValue="")String username){
        List<SysUser> userList = sysUserService.getAllSysUser();
        PageHelper.startPage(pageNum,5);
        if (!id.equals(-1)){
            SysUser sysUser =  null;
            for (SysUser user:userList) {
                if (user.getId().equals(id)){
                    sysUser=user;
                    userList.clear();
                    break;
                }
            }
            userList.clear();
            if (sysUser!=null){
                userList.add(sysUser);
            }
        }
        if (StringUtils.isBlank(phone)){
            List<SysUser> search = new ArrayList<>();
            for (SysUser user:userList)  {
                if (StringUtils.contains(user.getPhone(),phone)){
                    search.add(user);
                }
            }
            userList.clear();
            userList.addAll(search);
        }
        if (StringUtils.isBlank(username)){
            List<SysUser> search = new ArrayList<>();
            for (SysUser user:userList)  {
                if (StringUtils.contains(user.getUsername(),username)){
                    search.add(user);
                }
            }
            userList.clear();
            userList.addAll(search);
        }
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        model.addAttribute("userList",userList);
        model.addAttribute("page",pageInfo);
        return "admin/admin/users";
    }
    public Result getRole(){

        return ResultFactory.buildSuccessResult("");
    }

    /**
     * 功能描述 文件管理
     * @author xgl
     * @date 2020/2/18
     * @return java.lang.String
     */
    public String fileSystemControl(){
        return "";
    }

    @RequestMapping("/loginOut")
    public String loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return login();
    }
}
