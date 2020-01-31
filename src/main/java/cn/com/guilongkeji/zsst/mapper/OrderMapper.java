package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface OrderMapper {
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
}