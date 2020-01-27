package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
@Table(name = "order_detail")
public class OrderDetail {
    /**
     * 详单编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 菜品编号
     */
    @Column(name = "dish_id")
    private Integer dishId;

    /**
     * 菜品数量
     */
    private Integer count;

    /**
     * 获取详单编号
     *
     * @return id - 详单编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置详单编号
     *
     * @param id 详单编号
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取菜品数量
     *
     * @return count - 菜品数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置菜品数量
     *
     * @param count 菜品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}