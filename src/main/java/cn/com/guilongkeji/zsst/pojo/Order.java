package cn.com.guilongkeji.zsst.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Order {
    /**
     * 订单编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 创建用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 详单编号
     */
    private Integer details;

    /**
     * 取单码
     */
    private Integer code;

    /**
     * 订单状态
     */
    private Byte type;

    /**
     * 支付方式
     */
    private String method;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 折扣后
     */
    private BigDecimal value;

    /**
     * 订单评价
     */
    private String assess;

    /**
     * 状态码
     */
    private Byte status;

    /**
     * 获取订单编号
     *
     * @return id - 订单编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单编号
     *
     * @param id 订单编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建用户编号
     *
     * @return user_id - 创建用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置创建用户编号
     *
     * @param userId 创建用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取详单编号
     *
     * @return details - 详单编号
     */
    public Integer getDetails() {
        return details;
    }

    /**
     * 设置详单编号
     *
     * @param details 详单编号
     */
    public void setDetails(Integer details) {
        this.details = details;
    }

    /**
     * 获取取单码
     *
     * @return code - 取单码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置取单码
     *
     * @param code 取单码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取订单状态
     *
     * @return type - 订单状态
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置订单状态
     *
     * @param type 订单状态
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取支付方式
     *
     * @return method - 支付方式
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置支付方式
     *
     * @param method 支付方式
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
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
     * 获取原价
     *
     * @return price - 原价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置原价
     *
     * @param price 原价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取折扣后
     *
     * @return value - 折扣后
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * 设置折扣后
     *
     * @param value 折扣后
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * 获取订单评价
     *
     * @return assess - 订单评价
     */
    public String getAssess() {
        return assess;
    }

    /**
     * 设置订单评价
     *
     * @param assess 订单评价
     */
    public void setAssess(String assess) {
        this.assess = assess == null ? null : assess.trim();
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