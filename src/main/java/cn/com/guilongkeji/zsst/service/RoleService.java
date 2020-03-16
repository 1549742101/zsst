package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.Resource;
import cn.com.guilongkeji.zsst.pojo.SysRole;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */
public interface RoleService {
    /**
     * 功能描述 增加角色
     * @author xgl
     * @date 2020/1/13
     * @param sysRole
     * @return void
     */
    public void addRole(SysRole sysRole);
    /**
     * 功能描述 修改角色
     * @author xgl
     * @date 2020/1/13
     * @param sysRole
     * @return void
     */
    public void updateRole(SysRole sysRole);
    /**
     * 功能描述 批量更新角色
     * @author xgl
     * @date 2020/1/13
     * @param sysRoleList
     * @return void
     */
    public void updateRoles(List<SysRole> sysRoleList);
    /**
     * 功能描述 批量增加角色
     * @author xgl
     * @date 2020/1/13
     * @param sysRoleList
     * @return void
     */
    public void addAllRole(List<SysRole> sysRoleList);
    /**
     * 功能描述 根据角色id获取角色
     * @author xgl
     * @date 2020/1/13
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.SysRole
     */
    public SysRole getRoleById(Integer id);
    /**
     * 功能描述 根据用户获取角色
     * @author xgl
     * @date 2020/1/13
     * @param ids
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysRole>
     */
    public List<SysRole> getRoleByAll(List<Integer> ids);
    /**
     * 功能描述 获取所有角色
     * @author xgl
     * @date 2020/1/13
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysRole>
     */
    public List<SysRole> getAllRole();
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/6
      * @param sysRole
     * @return void
     */
    public void removeRole(SysRole sysRole);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/6
      * @param sysRoleList
     * @return void
     */
    public void removeAllRoles(List<SysRole> sysRoleList);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/13
      * @param
     * @return java.util.HashMap<java.lang.Integer,java.util.List<cn.com.guilongkeji.zsst.pojo.Resource>>
     */
    public HashMap<Integer,List<Resource>> getResourceByRole();
}
