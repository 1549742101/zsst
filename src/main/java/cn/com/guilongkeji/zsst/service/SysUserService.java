package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.SysUser;

/**
 * @Description 管理员
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/12
 */
public interface SysUserService {
    public SysUser isLogin(String username,String password);
    public boolean updateSysUser(SysUser sysUser);
}
