package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;

import java.util.List;

/**
 * @Description 用户
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public interface UserService {
    /**
     * 功能描述  根据用户名判断用户名是否被创建
     * @author xgl
     * @date 2020/1/5
     * @param username
     * @return boolean
     */
    public boolean isExist(String username);
    /**
     * 功能描述 根据用户名获取用户
     * @author xgl
     * @date 2020/1/13
      * @param username
     * @return cn.com.guilongkeji.zsst.pojo.SysUser
     */
    public SysUser getUserByName(String username);
    /**
     * 功能描述 登录、授权
     * @author xgl
     * @date 2020/1/5
      * @param username
     * @param password
     * @return cn.com.guilongkeji.zsst.pojo.SysUser
     */
    public SysUser getByUsernameAndPassword(String username,String password);
    /**
     * 功能描述 用户注册
     * @author xgl
     * @date 2020/1/5
      * @param sysUser
     * @return void
     */
    public void registerSysUser(SysUser sysUser);
    /**
     * 功能描述 用户信息更新
     * @author xgl
     * @date 2020/1/5
      * @param sysUser
     * @return void
     */
    public void updateSysUser(SysUser sysUser);
    /**
     * 功能描述 查询所有用户
     * @author xgl
     * @date 2020/1/5
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysUser>
     */
    public List<SysUser> getAllSysUser();
    /**
     * 功能描述 批量注册用户
     * @author xgl
     * @date 2020/1/5
      * @param  sysUserList
     * @return void
     */
    public void registerAllSysUser(List<SysUser> sysUserList);

    /**
     * 功能描述 获取验证码
     * @author xgl
     * @date 2020/1/12
      * @param code
     * @return void
     */
    public void insertCode(Code code);
    /**
     * 功能描述 验证验证码
     * @author xgl
     * @date 2020/1/12
      * @param phone
     * @return cn.com.guilongkeji.zsst.pojo.Code
     */
    public Code getCodeByPhone(String phone);
    /**
     * 功能描述 根据用户编号获取用户详情
     * @author xgl
     * @date 2020/1/31
      * @param uid
     * @return cn.com.guilongkeji.zsst.pojo.UserDetail
     */
    public UserDetail getUserDetailByUserId(Integer uid);
    /**
     * 功能描述 添加用户详情
     * @author xgl
     * @date 2020/1/31
      * @param userDetail
     * @return void
     */
    public void addUserDetail(UserDetail userDetail);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/31
      * @param userDetail
     * @return
     */
    public void updateUserDetail(UserDetail userDetail);
    /**
     * 功能描述 删除用户详情
     * @author xgl
     * @date 2020/1/31
      * @param id
     * @return void
     */
    @Deprecated
    public void removeUserDetail(Integer id);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/31
      * @param userDetail
     * @return void
     */
    public void deleteUserDetail(UserDetail userDetail);



}
