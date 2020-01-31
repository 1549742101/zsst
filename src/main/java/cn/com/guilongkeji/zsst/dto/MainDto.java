package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.*;
import lombok.Data;

import java.util.List;

/**
 * @Description 数据传输对象（Data Transfer Object）用于封装多个实体类（domain）之间的关系，不破坏原有的实体类结构
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/3
 */
@Data
public class MainDto {
    private Active active;
    private List<Active> activeList;
    private Assess assess;
    private List<Assess> assessList;
    private Cart cart;
    private List<Cart> cartList;
    private Code code;
    private List<Code> codeList;
    private Dish dish;
    private List<Dish> dishList;
    private Img img;
    private List<Img> imgList;
    private Order order;
    private List<Order> orderList;
    private OrderDetail orderDetail;
    private List<OrderDetail> orderDetailList;
    private Record record;
    private List<Record> recordList;
    private Shop shop;
    private List<Shop> shopList;
    private SysResource sysResource;
    private List<SysResource> sysResourceList;
    private SysRole sysRole;
    private List<SysRole> sysRoleList;
    private SysUser sysUser;
    private List<SysUser> sysUserList;
    private UserDetail userDetail;
    private List<UserDetail> userDetailList;
}
