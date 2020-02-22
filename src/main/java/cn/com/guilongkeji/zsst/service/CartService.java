package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.Cart;
import cn.com.guilongkeji.zsst.pojo.Dish;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */
public interface CartService {
    /**
     * 功能描述 添加购物车
     * @author xgl
     * @date 2020/1/28
     * @param cart
     * @return void
     */
    public void addCart(Cart cart);
    /**
     * 功能描述 批量添加购物车
     * @author xgl
     * @date 2020/1/28
     * @param carts
     * @return void
     */
    public void addAllCart(List<Cart> carts);
    /**
     * 功能描述 更新购物车
     * @author xgl
     * @date 2020/1/28
     * @param cart
     * @return void
     */
    public void updateCart(Cart cart);
    /**
     * 功能描述 批量更新购物车
     * @author xgl
     * @date 2020/1/28
     * @param carts
     * @return void
     */
    public void updateAllCart(List<Cart> carts);
    /**
     * 功能描述 删除购物车
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return void
     */
    @Deprecated
    public void removeCart(Integer id);
    /**
     * 功能描述 删除购物车
     * @author xgl
     * @date 2020/1/28
     * @param ids
     * @return void
     */
    @Deprecated
    public void removeAllCart(List<Integer> ids);
    /**
     * 功能描述 获取所有购物车
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Cart>
     */
    public List<Cart> getAllCart();
    /**
     * 功能描述 根据编号获取购物车
     * @author xgl
     * @date 2020/1/28
     * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Cart>
     */
    public List<Cart> getCartByUser(Integer uid);
    /**
     * 功能描述 根据状态获取购物车
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Cart>
     */
    public List<Cart> getCartByStatus();
    /**
     * 功能描述 根据购物车添加的菜品获取最大值菜品
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return cn.com.guilongkeji.zsst.pojo.Dish
     */
    public Dish getDishByCartMax();
}
