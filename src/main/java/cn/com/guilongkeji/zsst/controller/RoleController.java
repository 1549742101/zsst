package cn.com.guilongkeji.zsst.controller;


import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import cn.com.guilongkeji.zsst.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */
@Controller
@RequestMapping("/admin")
public class RoleController {
    @Resource
    private RoleService roleService;
    @RequestMapping("addRole")
    @ResponseBody
    public Result addRole(SysRole sysRole){
        roleService.addRole(sysRole);
        return ResultFactory.buildSuccessResult(sysRole);
    }
    @RequestMapping("removeRole")
    @ResponseBody
    public Result removeRole(SysRole sysRole){
        roleService.removeRole(sysRole);
        return ResultFactory.buildSuccessResult(sysRole);
    }
    public Result removeRoles(List<SysRole> sysRoleList){
        roleService.removeAllRoles(sysRoleList);
        return ResultFactory.buildSuccessResult(sysRoleList);
    }
    @RequestMapping("/getAllRoles")
    public String getAllRoles(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=true,defaultValue="")String roleName,@RequestParam(required=true,defaultValue="-1")Integer id){
        PageHelper.startPage(pageNum,5);
        List<SysRole> list = roleService.getAllRole();
        if (id!=-1){
            SysRole sysRole = roleService.getRoleById(id);
            list.clear();
            if (sysRole!=null){
                list.add(sysRole);
            }
        }
        if (StringUtils.isBlank(roleName)) {
            List<SysRole> search = new ArrayList<>();
            for (SysRole sysRole:list){
                if (sysRole.getRole().contains(roleName)){
                    search.add(sysRole);
                }
            }
            list.clear();
            list.addAll(search);
        }
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        model.addAttribute("roles",list);
        model.addAttribute("page",pageInfo);
        return "admin/admin/roles";
    }
}
