package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.dto.ShopDto;
import cn.com.guilongkeji.zsst.mapper.*;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Order;
import cn.com.guilongkeji.zsst.pojo.Shop;
import cn.com.guilongkeji.zsst.service.ShopService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ImgMapper imgMapper;
    @Resource
    private DishMapper dishMapper;
    @Resource
    private ActiveMapper activeMapper;
    @Override
    public List<Order> getOrderByUserId(Integer uid) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void deleteOrderById(Integer id) {

    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public void addShop(Shop shop) {

    }

    @Override
    public void addAllShop(List<Shop> shops) {

    }

    @Override
    public void updateShop(Shop shop) {

    }

    @Override
    public void updateShops(List<Shop> shops) {

    }

    @Override
    public void removeShop(Integer id) {

    }

    @Override
    public void removeShops(List<Integer> ids) {

    }

    @Override
    public Shop getShopById(Integer id) {
        return shopMapper.getShopById(id);
    }

    @Override
    public List<Shop> getAllShop() {
        return shopMapper.getAllShop();
    }

    @Override
    public List<ShopDto> getHotsShop() {
        List<Shop> shopList = shopMapper.getHotsShop();
        List<ShopDto> shopDtoList = new ArrayList<>();
        for (Shop shop:shopList){
            ShopDto shopDto = new ShopDto(shop);
            shopDto.setDishList(dishMapper.getDishByShop(shop.getId()));
            double[] c = centerMoney(shopDto.getDishList());
            shopDto.setImg(imgMapper.getImgById(shop.getAvatar()));
            shopDto.setHotDish(dishMapper.getDishById(shop.getDishId()));
            shopDto.setCenterMoney(c[0]);
            shopDto.setPraise((int)c[1]);
            shopDto.setSale((int)c[2]);
            shopDto.setSales((int)c[3]);
            shopDto.setActive(activeMapper.getHotsActiveByShop(shop.getId()));
            shopDtoList.add(shopDto);
        }
        return shopDtoList;
    }
    private double[] centerMoney(List<Dish> list){
        int sales = 0;
        int sale = 0;
        double money = 0;
        int count = 0;
        double[] c = {0,0,0,0};
        int pra = 0;
        for (Dish dish:list){
            sale+=dish.getSale();
            sales+=dish.getSales();
            money+=(dish.getSales()*dish.getMoney().doubleValue());
            if ((!dish.getPraise().equals(BigDecimal.ZERO))&&dish.getPraise().doubleValue()!=0){
                pra+=dish.getPraise().doubleValue()*100;
                count++;
            }
        }
        if (sales!=0){
            c[0]= money/sales;
        }
        if (count!=0){
            c[1] = pra/count;
        }else {
            c[1] = 100;
        }
        c[2]=sale;
        c[3]=sales;
        return c;
    }

    @Override
    public List<Shop> search(Shop shop) {
        List<Shop> list = new ArrayList<>();
        if (!ObjectUtils.isEmpty(shop)){
            List<Shop> shopList = this.getAllShop();
            String name = shop.getName();
            if (StringUtils.isNotEmpty(name)){
                for (Shop shop1 : shopList){
                    if (StringUtils.contains(shop1.getName(),shop.getName())){
                        list.add(shop1);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Shop> sort(List<Shop> list,Integer o) {
        switch (o){
            case 2:
                Collections.sort(
                        list,(o2,o1)->o1.getName().compareToIgnoreCase(o2.getName())
                );break;
            case 3:
                Collections.sort(
                        list,(o1,o2)->o1.getId().compareTo(o2.getId())
                );break;
            default:
                Collections.sort(
                        list,(o2,o1)->o1.getHistory().compareTo(o2.getHistory())
                );
        }
        return list;
    }
}
