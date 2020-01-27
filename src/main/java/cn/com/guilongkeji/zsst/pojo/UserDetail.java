package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
@Table(name = "user_detail")
public class UserDetail {
    /**
     * 用户详情
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 头像
     */
    private Integer avatar;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 认证方式
     */
    private String method;

    /**
     * 认证图片路径
     */
    private Integer img;

    /**
     * 认证码
     */
    private String code;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 获取用户详情
     *
     * @return id - 用户详情
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户详情
     *
     * @param id 用户详情
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public Integer getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取认证方式
     *
     * @return method - 认证方式
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置认证方式
     *
     * @param method 认证方式
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取认证图片路径
     *
     * @return img - 认证图片路径
     */
    public Integer getImg() {
        return img;
    }

    /**
     * 设置认证图片路径
     *
     * @param img 认证图片路径
     */
    public void setImg(Integer img) {
        this.img = img;
    }

    /**
     * 获取认证码
     *
     * @return code - 认证码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置认证码
     *
     * @param code 认证码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}