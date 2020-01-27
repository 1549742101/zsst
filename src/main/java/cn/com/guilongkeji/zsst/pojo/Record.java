package cn.com.guilongkeji.zsst.pojo;

import java.util.Date;
import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Record {
    /**
     * 浏览记录
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 浏览店铺编号
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 浏览时间
     */
    private Date time;

    /**
     * 状态码
     */
    private Byte status;

    /**
     * 获取浏览记录
     *
     * @return id - 浏览记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置浏览记录
     *
     * @param id 浏览记录
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取浏览店铺编号
     *
     * @return shop_id - 浏览店铺编号
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置浏览店铺编号
     *
     * @param shopId 浏览店铺编号
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    /**
     * 获取浏览时间
     *
     * @return time - 浏览时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置浏览时间
     *
     * @param time 浏览时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取状态码
     *
     * @return status - 状态码
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态码
     *
     * @param status 状态码
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
    public void setBStatus(boolean status){
        Byte zero = 0;
        Byte one = 1;
        this.status=status?one:zero;
    }
    public boolean getBStatus(){
        return this.status>0?true:false;
    }
}