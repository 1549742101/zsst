package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.dto.OrderDto;
import cn.com.guilongkeji.zsst.dto.ShopDto;
import cn.com.guilongkeji.zsst.pojo.Order;
import cn.com.guilongkeji.zsst.pojo.Shop;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */
public interface ShopService {
    /**
     * 功能描述 根据用户编号获取订单
     * @author xgl
     * @date 2020/1/30
     * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Order>
     */
    public List<Order> getOrderByUserId(Integer uid);
    /**
     * 功能描述 添加订单
     * @author xgl
     * @date 2020/1/30
     * @param order
     * @return void
     */
    public void addOrder(Order order);
    /**
     * 功能描述 删除订单
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void deleteOrderById(Integer id);
    /**
     * 功能描述 更新订单
     * @author xgl
     * @date 2020/1/30
     * @param order
     * @return void
     */
    public void updateOrder(Order order);
    /**
     * 功能描述 获取所有订单
     * @author xgl
     * @date 2020/1/30
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Order>
     */
    public List<Order> getAllOrder();
    /**
     * 功能描述 增加店铺
     * @author xgl
     * @date 2020/1/30
     * @param shop
     * @return void
     */
    public void addShop(Shop shop);
    /**
     * 功能描述 批量增加店铺
     * @author xgl
     * @date 2020/1/30
     * @param shops
     * @return void
     */
    public void addAllShop(List<Shop> shops);
    /**
     * 功能描述 更新店铺信息
     * @author xgl
     * @date 2020/1/30
     * @param shop
     * @return void
     */
    public void updateShop(Shop shop);
    /**
     * 功能描述 更新店铺信息
     * @author xgl
     * @date 2020/1/30
     * @param shops
     * @return void
     */
    public void updateShops(List<Shop> shops);
    /**
     * 功能描述 删除店铺
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void removeShop(Integer id);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/30
     * @param ids
     * @return void
     */
    @Deprecated
    public void removeShops(List<Integer> ids);
    /**
     * 功能描述 获取店铺
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Shop
     */
    public Shop getShopById(Integer id);
    /**
     * 功能描述 获取店铺
     * @author xgl
     * @date 2020/1/30
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Shop>
     */
    public List<Shop> getAllShop();

    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/10
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.ShopDto
     */
    public List<ShopDto> getHotsShop();
}
