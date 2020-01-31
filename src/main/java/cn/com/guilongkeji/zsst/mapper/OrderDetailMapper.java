package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.dto.OrderDetailDto;
import cn.com.guilongkeji.zsst.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface OrderDetailMapper {
    /**
     * 功能描述 增加订单详情
     * @author xgl
     * @date 2020/1/30
      * @param orderDetail
     * @return void
     */
    public void addOrderDetail(OrderDetail orderDetail);
    /**
     * 功能描述 批量增加订单详情
     * @author xgl
     * @date 2020/1/30
      * @param orderDetails
     * @return void
     */
    public void addAllOrderDetail(List<OrderDetail> orderDetails);
    /**
     * 功能描述 更新订单详情
     * @author xgl
     * @date 2020/1/30
      * @param orderDetail
     * @return void
     */
    public void updateOrderDetail(OrderDetail orderDetail);
    /**
     * 功能描述 批量更新订单详情
     * @author xgl
     * @date 2020/1/30
      * @param orderDetails
     * @return void
     */
    public void updateAllOrderDetail(List<OrderDetail> orderDetails);
    /**
     * 功能描述 删除订单详情
     * @author xgl
     * @date 2020/1/30
      * @param id
     * @return void
     */
    @Deprecated
    public void removeOrderDetail(Integer id);
    /**
     * 功能描述 删除订单详情
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void removeOrderDetailByOrder(Integer id);
    /**
     * 功能描述 批量删除订单详情
     * @author xgl
     * @date 2020/1/30
      * @param ids
     * @return void
     */
    @Deprecated
    public void removeAllOrderDetail(List<Integer> ids);
    /**
     * 功能描述 获取所有订单详情
     * @author xgl
     * @date 2020/1/30
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.OrderDetail>
     */
    public List<OrderDetail> getAllOrderDetail();
    /**
     * 功能描述 根据订单编号获取订单详情
     * @author xgl
     * @date 2020/1/30
      * @param oid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.OrderDetail>
     */
    public List<OrderDetail> getOrderDetailByOrderId(Integer oid);
    /**
     * 功能描述 根据菜品获取订单详情
     * @author xgl
     * @date 2020/1/30
      * @param did
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.OrderDetail>
     */
    public List<OrderDetail> getOrderDetailByDish(Integer did);
    /**
     * 功能描述 根据详情编号获取订单详情
     * @author xgl
     * @date 2020/1/30
      * @param id
     * @return cn.com.guilongkeji.zsst.pojo.OrderDetail
     */
    public OrderDetail getOrderDetailById(Integer id);
    /**
     * 功能描述 根据菜品编号获取订单详情
     * @author xgl
     * @date 2020/1/30
      * @param dishIdes
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.OrderDetail>
     */
    public List<OrderDetail> getOrderDetailByAllDish(List<Integer> dishIdes);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/30
      * @param oid
     * @return java.util.List<cn.com.guilongkeji.zsst.dto.OrderDetailDto>
     */
    public List<OrderDetailDto> getOrderDetailDtoByOrderId(Integer oid);
}