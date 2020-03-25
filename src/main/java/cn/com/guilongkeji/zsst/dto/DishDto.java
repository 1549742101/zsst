package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.Dish;

/**
 * @author : xgl
 * @date : 2020/3/20 10:36
 * @Description :
 */
public class DishDto extends Dish {
    public DishDto() {
        super();
    }
    public DishDto(Dish dish){
        super();
        this.setId(dish.getId());
        this.setName(dish.getName());
        this.setPraise(dish.getPraise());
        this.setSale(dish.getSale());
        this.setBActive(dish.getBActive());
        this.setStatus(dish.getStatus());
        this.setMoney(dish.getMoney());
        this.setImg(dish.getImg());
        this.setSales(dish.getSales());
        this.setShopId(dish.getShopId());
        this.setDetail(dish.getDetail());
    }
}
