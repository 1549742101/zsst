package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.pojo.Cart;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */
@Service
public class CartServiceImpl implements CartService {
    @Override
    public void addCart(Cart cart) {

    }

    @Override
    public void addAllCart(List<Cart> carts) {

    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void updateAllCart(List<Cart> carts) {

    }

    @Override
    public void removeCart(Integer id) {

    }

    @Override
    public void removeAllCart(List<Integer> ids) {

    }

    @Override
    public List<Cart> getAllCart() {
        return null;
    }

    @Override
    public List<Cart> getCartByUser(Integer uid) {
        return null;
    }

    @Override
    public List<Cart> getCartByStatus() {
        return null;
    }

    @Override
    public Dish getDishByCartMax() {
        return null;
    }

    @Override
    public List<Cart> search(Cart cart) {
        return null;
    }

    @Override
    public List<Cart> sort(List<Cart> list,Integer o) {
        return null;
    }
}
