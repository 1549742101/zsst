package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import lombok.Data;

/**
 * @author XGL
 * @date 2020/2/22
 */
@Data
public class UserDto{
    private SysUser sysUser;
    private UserDetail userDetail;
}
