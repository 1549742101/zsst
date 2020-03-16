package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.ResourceMapper;
import cn.com.guilongkeji.zsst.mapper.SysRoleMapper;
import cn.com.guilongkeji.zsst.pojo.Resource;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.service.RoleService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */
@Service
public class RoleServiceImpl implements RoleService {
    @javax.annotation.Resource
    private SysRoleMapper sysRoleMapper;
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;
    @Override
    public void addRole(SysRole sysRole) {
        sysRoleMapper.addRole(sysRole);
    }

    @Override
    public void updateRole(SysRole sysRole) {
        sysRoleMapper.updateRole(sysRole);
    }

    @Override
    public void updateRoles(List<SysRole> sysRoleList) {
        sysRoleMapper.updateRoles(sysRoleList);
    }

    @Override
    public void addAllRole(List<SysRole> sysRoleList) {
        sysRoleMapper.addAllRole(sysRoleList);
    }

    @Override
    public SysRole getRoleById(Integer id) {
        return sysRoleMapper.getRoleById(id);
    }

    @Override
    public List<SysRole> getRoleByAll(List<Integer> ids) {
        return sysRoleMapper.getRoleByAll(ids);
    }

    @Override
    public List<SysRole> getAllRole() {
        return sysRoleMapper.getAllRole();
    }

    @Override
    public void removeRole(SysRole sysRole) {
        sysRole.setBAvailable(false);
        sysRoleMapper.updateRole(sysRole);
    }

    @Override
    public void removeAllRoles(List<SysRole> sysRoleList) {
        List<SysRole> sysRoles=new ArrayList<>();
        for (SysRole s:sysRoleList){
            s.setBAvailable(false);
            sysRoles.add(s);
        }
        sysRoleMapper.updateRoles(sysRoles);
    }
    @Override
    public HashMap<Integer,List<Resource>> getResourceByRole(){
        List<SysRole> sysRoleList = sysRoleMapper.getAllRole();
        HashMap<Integer,List<Resource>> result= new HashMap<>();
        for (SysRole sysRole:sysRoleList){
            List<Resource> resources = resourceMapper.getResourceByAll(StringUtils.StringToList(sysRole.getResourceIds()));
            result.put(sysRole.getId(), resources);
        }
        return result;
    }
}
