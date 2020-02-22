package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.Active;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.pojo.Shop;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/11
 */
@Data
public class ShopDto extends Shop {
    private Img img;
    private List<Dish> dishList;
    private Dish hotDish;
    private double centerMoney;
    private Active active;
    private Integer praise;
    private Integer sale;
    private Integer sales;
    public ShopDto() {
    }
    public ShopDto(Shop shop){
        this.setAvatar(shop.getAvatar());
        this.setBStatus(shop.getBStatus());
        this.setId(shop.getId());
        this.setDishId(shop.getDishId());
        this.setHistory(shop.getHistory());
        this.setName(shop.getName());
        this.setRegion(shop.getRegion());
    }
}
