package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.Order;
import cn.com.guilongkeji.zsst.pojo.OrderDetail;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */
public class OrderDto extends Order {
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
