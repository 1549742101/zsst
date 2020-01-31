package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.dto.MainDto;
import cn.com.guilongkeji.zsst.dto.OrderDto;
import cn.com.guilongkeji.zsst.pojo.Order;

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
     * 功能描述 生成订单,包含订单详情
     * @author xgl
     * @date 2020/1/27
      * @param  mainDto
     * @return void
     */
    public void addOrder(MainDto mainDto);
    /**
     * 功能描述 更新订单
     * @author xgl
     * @date 2020/1/27
     * @param mainDto
     * @return void
     */
    public void updateOrder(MainDto mainDto);
    /**
     * 功能描述 批量更新订单
     * @author xgl
     * @date 2020/1/30
      * @param mainDto
     * @return void
     */
    public void updateOrders(MainDto mainDto);
    /**
     * 功能描述 删除订单，伪删除
     * @author xgl
     * @date 2020/1/27
     * @param mainDto
     * @return void
     */
    public void deleteOrder(MainDto mainDto);
    /**
     * 功能描述 删除订单，伪删除
     * @author xgl
     * @date 2020/1/27
     * @param mainDto
     * @return void
     */
    public void deleteOrders(MainDto mainDto);
    /**
     * 功能描述 删除订单，真删除
     * @author xgl
     * @date 2020/1/30
      * @param mainDto
     * @return void
     */
    public void removeOrder(MainDto mainDto);
    /**
     * 功能描述 根据用户id获取订单
     * @author xgl
     * @date 2020/1/27
      * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Order>
     */
    public List<MainDto> getOrderByUserId(Integer uid);
    /**
     * 功能描述 获取所有订单
     * @author xgl
     * @date 2020/1/27
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.dto.OrderDto>
     */
    public List<MainDto> getAllOrder();
    /**
     * 功能描述 根据订单id获取订单
     * @author xgl
     * @date 2020/1/27
      * @param id
     * @return cn.com.guilongkeji.zsst.dto.OrderDto
     */
    public OrderDto getOrderById(Integer id);
}
