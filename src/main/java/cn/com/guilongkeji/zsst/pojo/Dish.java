package cn.com.guilongkeji.zsst.pojo;

import java.math.BigDecimal;
import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
public class Dish {
    /**
     * 菜品编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 售价
     */
    private BigDecimal money;

    /**
     * 菜品图片
     */
    private Integer img;

    /**
     * 总共销售了多少
     */
    private Integer sales;

    /**
     * 今日销售了多少、每日24点更新
     */
    private Integer sale;

    /**
     * 好评度、默认为0
     */
    private BigDecimal praise;

    /**
     * 店铺绑定
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 活动状态
     */
    private Byte active;

    /**
     * 菜品存活状态
     */
    private Byte status;
    /**
     * 获取菜品编号
     *
     * @return id - 菜品编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜品编号
     *
     * @param id 菜品编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜品名称
     *
     * @return name - 菜品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜品名称
     *
     * @param name 菜品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取售价
     *
     * @return money - 售价
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置售价
     *
     * @param money 售价
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取菜品图片
     *
     * @return img - 菜品图片
     */
    public Integer getImg() {
        return img;
    }

    /**
     * 设置菜品图片
     *
     * @param img 菜品图片
     */
    public void setImg(Integer img) {
        this.img = img;
    }

    /**
     * 获取总共销售了多少
     *
     * @return sales - 总共销售了多少
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置总共销售了多少
     *
     * @param sales 总共销售了多少
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * 获取今日销售了多少、每日24点更新
     *
     * @return sale - 今日销售了多少、每日24点更新
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置今日销售了多少、每日24点更新
     *
     * @param sale 今日销售了多少、每日24点更新
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * 获取好评度、默认为0
     *
     * @return praise - 好评度、默认为0
     */
    public BigDecimal getPraise() {
        return praise;
    }

    /**
     * 设置好评度、默认为0
     *
     * @param praise 好评度、默认为0
     */
    public void setPraise(BigDecimal praise) {
        this.praise = praise;
    }

    /**
     * 获取店铺绑定
     *
     * @return shop_id - 店铺绑定
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置店铺绑定
     *
     * @param shopId 店铺绑定
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取活动状态
     *
     * @return active - 活动状态
     */
    public Byte getActive() {
        return active;
    }

    /**
     * 设置活动状态
     *
     * @param active 活动状态
     */
    public void setActive(Byte active) {
        this.active = active;
    }

    /**
     * 获取菜品存活状态
     *
     * @return status - 菜品存活状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置菜品存活状态
     *
     * @param status 菜品存活状态
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
    public void setBActive(boolean active){
        Byte zero = 0;
        Byte one = 1;
        this.active=active?one:zero;
    }
    public boolean getBActive(){
        return this.active>0?true:false;
    }
}