package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
@RequestMapping("/api/admin")
public class SysUserController {
    @ResponseBody
    public Result loginByAdmin(@RequestBody SysUser sysUser){
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        sysUser.setUsername(username);
        return ResultFactory.buildFailResult("");
    }
}
