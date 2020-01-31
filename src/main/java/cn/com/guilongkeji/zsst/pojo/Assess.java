package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述 评价
 * @author xgl
 * @date 2020/1/5
 */
public class Assess {
    /**
     * 评价编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

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
     * 订单编号
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 评价内容
     */
    private String text;

    /**
     * 评价星级
     */
    private Integer star;

    /**
     * 评价图片
     */
    private Integer img;

    /**
     *
     */
    private Byte status;
    /**
     * 获取评价编号
     *
     * @return id - 评价编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评价编号
     *
     * @param id 评价编号
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取订单编号
     *
     * @return order_id - 订单编号
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单编号
     *
     * @param orderId 订单编号
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取评价内容
     *
     * @return text - 评价内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置评价内容
     *
     * @param text 评价内容
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 获取评价星级
     *
     * @return star - 评价星级
     */
    public Integer getStar() {
        return star;
    }

    /**
     * 设置评价星级
     *
     * @param star 评价星级
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * 获取评价图片
     *
     * @return img - 评价图片
     */
    public Integer getImg() {
        return img;
    }

    /**
     * 设置评价图片
     *
     * @param img 评价图片
     */
    public void setImg(Integer img) {
        this.img = img;
    }

    public Byte getStatus() {
        return status;
    }

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