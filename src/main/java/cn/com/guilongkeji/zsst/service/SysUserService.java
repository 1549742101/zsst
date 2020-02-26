package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.dto.UserDto;
import cn.com.guilongkeji.zsst.pojo.SysResource;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;

import java.util.List;

/**
 * @Description 管理员
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/12
 */
public interface SysUserService {
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param username
     * @param password
     * @return cn.com.guilongkeji.zsst.pojo.SysUser
     */
    public SysUser isLogin(String username,String password);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param sysUser
     * @return boolean
     */
    public boolean updateSysUser(SysUser sysUser);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param
     * @return cn.com.guilongkeji.zsst.pojo.UserDetail
     */
    public List<UserDetail> getAllUserDetail();

    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getAllSysUser();

    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param ids
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getAllSysUserByIds(List<Integer> ids);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param ids
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getAllSysUserByExcludeIds(List<Integer> ids);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
      * @param
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> getUserByDetail();
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getUserByRolesOne();
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param
     * @return java.util.List<javax.management.relation.Role>
     */
    public List<SysRole> getAllRole();
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysResource>
     */
    public List<SysResource> getResourceOne();
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysResource>
     */
    public List<SysResource> getResourceTwo();

    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/4
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.dto.UserDto>
     */
    public List<UserDto> getAllUser();
}
