package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.DishMapper;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Shop;
import cn.com.guilongkeji.zsst.service.DishService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : xgl
 * @date : 2020/3/17 0:18
 * @description :
 */
@Service
public class DishServiceImpl implements DishService {
    @Resource
    private DishMapper dishMapper;
    @Override
    public void addDish(Dish dish) {
        dishMapper.addDish(dish);
    }

    @Override
    public void addAllDish(List<Dish> dishes) {
        dishMapper.addAllDish(dishes);
    }

    @Override
    public void removeDish(Integer id) {
        dishMapper.removeDish(id);
    }

    @Override
    public void removeDishes(List<Integer> ids) {
        dishMapper.removeDishes(ids);
    }

    @Override
    public void updateDish(Dish dish) {
        dishMapper.updateDish(dish);
    }

    @Override
    public void updateAllDish(List<Dish> dishes) {
        dishMapper.updateAllDish(dishes);
    }

    @Override
    public List<Dish> getAllDish() {
        return dishMapper.getAllDish();
    }

    @Override
    public List<Dish> getDishByShop(Integer sid) {
        return dishMapper.getDishByShop(sid);
    }

    @Override
    public Dish getDishById(Integer id) {
        return dishMapper.getDishById(id);
    }

    @Override
    public List<Dish> search(Dish dish) {
        List<Dish> list = new ArrayList<>();
        if (!ObjectUtils.isEmpty(dish)){
            List<Dish> dishList = this.getAllDish();
            String name = dish.getName();
            if (StringUtils.isNotEmpty(name)){
                for (Dish dish1 : dishList){
                    if (StringUtils.contains(dish1.getName(),dish.getName())){
                        list.add(dish1);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Dish> sort(List<Dish> list,Integer o) {
        switch (o){
            case 2:Collections.sort(list,(o1,o2)->o1.getPraise().compareTo(o2.getPraise()));break;
            case 3:Collections.sort(
                    list,(o2,o1)->o1.getName().compareToIgnoreCase(o2.getName()));break;
            default:Collections.sort(list,(o1,o2)->o1.getSales().compareTo(o2.getSales()));
        }
        return list;
    }
}
