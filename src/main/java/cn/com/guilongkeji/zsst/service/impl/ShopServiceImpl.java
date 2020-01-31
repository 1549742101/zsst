package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.dto.MainDto;
import cn.com.guilongkeji.zsst.dto.OrderDto;
import cn.com.guilongkeji.zsst.mapper.OrderDetailMapper;
import cn.com.guilongkeji.zsst.mapper.OrderMapper;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Order;
import cn.com.guilongkeji.zsst.pojo.OrderDetail;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.service.ShopService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */
public class ShopServiceImpl implements ShopService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public void addOrder(MainDto mainDto) {
        Order order = new Order();
        List<Dish> dishList = mainDto.getDishList();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        SysUser sysUser = mainDto.getSysUser();
        order.setBStatus(true);
        order.setTime(new Date());
        for(Dish dish:dishList){
            OrderDetail orderDetail = new OrderDetail();
            orderDetailList.add(orderDetail);
        }
    }

    @Override
    public void updateOrder(MainDto mainDto) {

    }

    @Override
    public void updateOrders(MainDto mainDto) {

    }

    @Override
    public void deleteOrder(MainDto mainDto) {

    }

    @Override
    public void deleteOrders(MainDto mainDto) {

    }

    @Override
    public void removeOrder(MainDto mainDto) {

    }

    @Override
    public List<MainDto> getOrderByUserId(Integer uid) {
        return null;
    }

    @Override
    public List<MainDto> getAllOrder() {
        return null;
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        return null;
    }
}
