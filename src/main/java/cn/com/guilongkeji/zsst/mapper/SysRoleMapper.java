package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 用户角色
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface SysRoleMapper {
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
}