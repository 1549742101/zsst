package cn.com.guilongkeji.zsst.pojo;

import java.util.Date;
import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Cart {
    /**
     * 购物车编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 状态码
     */
    private Byte status;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 菜品编号
     */
    @Column(name = "dish_id")
    private Integer dishId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 获取购物车编号
     *
     * @return id - 购物车编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置购物车编号
     *
     * @param id 购物车编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return time - 创建时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置创建时间
     *
     * @param time 创建时间
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
     * 获取菜品编号
     *
     * @return dish_id - 菜品编号
     */
    public Integer getDishId() {
        return dishId;
    }

    /**
     * 设置菜品编号
     *
     * @param dishId 菜品编号
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
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