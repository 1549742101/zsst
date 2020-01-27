package cn.com.guilongkeji.zsst.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Active {
    /**
     * 活动编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 店铺编号
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 活动事由
     */
    private String cause;

    /**
     * 活动条件
     */
    private BigDecimal term;

    /**
     * 状态码
     */
    private Byte status;

    /**
     * 获取活动编号
     *
     * @return id - 活动编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置活动编号
     *
     * @param id 活动编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取店铺编号
     *
     * @return shop_id - 店铺编号
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置店铺编号
     *
     * @param shopId 店铺编号
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取活动事由
     *
     * @return cause - 活动事由
     */
    public String getCause() {
        return cause;
    }

    /**
     * 设置活动事由
     *
     * @param cause 活动事由
     */
    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    /**
     * 获取活动条件
     *
     * @return term - 活动条件
     */
    public BigDecimal getTerm() {
        return term;
    }

    /**
     * 设置活动条件
     *
     * @param term 活动条件
     */
    public void setTerm(BigDecimal term) {
        this.term = term;
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