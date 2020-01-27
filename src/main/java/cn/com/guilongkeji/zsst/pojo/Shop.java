package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Shop {
    /**
     * 店铺详情编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 头像编号
     */
    private Integer avatar;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 主打菜编号
     */
    @Column(name = "dish_id")
    private Integer dishId;

    /**
     * 用户营业状态
     */
    private Byte status;

    /**
     * 区域编号
     */
    @Column(name = "region_id")
    private Integer regionId;

    /**
     * 浏览记录
     */
    private Integer history;

    /**
     * 获取店铺详情编号
     *
     * @return id - 店铺详情编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置店铺详情编号
     *
     * @param id 店铺详情编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取头像编号
     *
     * @return avatar - 头像编号
     */
    public Integer getAvatar() {
        return avatar;
    }

    /**
     * 设置头像编号
     *
     * @param avatar 头像编号
     */
    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取店铺名称
     *
     * @return name - 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置店铺名称
     *
     * @param name 店铺名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取主打菜编号
     *
     * @return dish_id - 主打菜编号
     */
    public Integer getDishId() {
        return dishId;
    }

    /**
     * 设置主打菜编号
     *
     * @param dishId 主打菜编号
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    /**
     * 获取用户营业状态
     *
     * @return status - 用户营业状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置用户营业状态
     *
     * @param status 用户营业状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取区域编号
     *
     * @return region_id - 区域编号
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置区域编号
     *
     * @param regionId 区域编号
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取浏览记录
     *
     * @return history - 浏览记录
     */
    public Integer getHistory() {
        return history;
    }

    /**
     * 设置浏览记录
     *
     * @param history 浏览记录
     */
    public void setHistory(Integer history) {
        this.history = history;
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