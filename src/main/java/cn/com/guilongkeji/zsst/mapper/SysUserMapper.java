package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 所有用户统一数据库
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface SysUserMapper {
    /**
     * 功能描述 通过用户名查找用户
     * @author xgl
     * @date 2020/1/5
     * @param username
     * @return cn.com.guilongkeji.zsst.pojo.SysUser
     */
    public SysUser findByUsername(String username);

    /**
     * 功能描述 用户认证
     * @author xgl
     * @date 2020/1/13
     * @param username
     * @param password
     * @return cn.com.guilongkeji.zsst.pojo.SysUser
     */
    public SysUser getByUsernameAndPassword(String username,String password);

    /**
     * 功能描述 增加用户
     * @author xgl
     * @date 2020/1/13
     * @param sysUser
     * @return boolean
     */
    public void addSysUser(SysUser sysUser);

    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/27
     * @param sysUser
     * @return boolean
     */
    public void updateSysUser(SysUser sysUser);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/31
     * @param sysUserList
     * @return void
     */
    public void addAllSysUser(List<SysUser> sysUserList);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/31
     * @param sysUserList
     * @return void
     */
    public void updateAllSysUser(List<SysUser> sysUserList);
    /**
     * 功能描述 获取所有用户
     * @author xgl
     * @date 2020/1/31
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getAllUser();
}