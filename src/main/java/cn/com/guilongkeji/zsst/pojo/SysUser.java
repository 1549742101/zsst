package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */

@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户标识，唯一id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名，用于登录认证，唯一
     */
    private String username;

    /**
     * 密码，加密
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 用户手机号，管理员赋值或用户创建时赋值
     */
    private String phone;

    /**
     * 角色列表
     */
    @Column(name = "role_ids")
    private String roleIds;

    /**
     * 账户是否锁定
     */
    private Byte locked;

    /**
     * 获取用户标识，唯一id
     *
     * @return id - 用户标识，唯一id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户标识，唯一id
     *
     * @param id 用户标识，唯一id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名，用于登录认证，唯一
     *
     * @return username - 用户名，用于登录认证，唯一
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名，用于登录认证，唯一
     *
     * @param username 用户名，用于登录认证，唯一
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码，加密
     *
     * @return password - 密码，加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码，加密
     *
     * @param password 密码，加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐值
     *
     * @return salt - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取用户手机号，管理员赋值或用户创建时赋值
     *
     * @return phone - 用户手机号，管理员赋值或用户创建时赋值
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号，管理员赋值或用户创建时赋值
     *
     * @param phone 用户手机号，管理员赋值或用户创建时赋值
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取角色列表
     *
     * @return role_ids - 角色列表
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * 设置角色列表
     *
     * @param roleIds 角色列表
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    /**
     * 获取账户是否锁定
     *
     * @return locked - 账户是否锁定
     */
    public Byte getLocked() {
        return locked;
    }

    /**
     * 设置账户是否锁定
     *
     * @param locked 账户是否锁定
     */
    public void setLocked(Byte locked) {
        this.locked = locked;
    }
    public void setBLocked(boolean status){
        Byte zero = 0;
        Byte one = 1;
        this.locked=status?one:zero;
    }
    public boolean getBLocked(){
        return this.locked>0?true:false;
    }
}