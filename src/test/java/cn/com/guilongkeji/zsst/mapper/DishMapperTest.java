package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.PocketCafeteriaApplication;
import cn.com.guilongkeji.zsst.pojo.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PocketCafeteriaApplication.class)
public class DishMapperTest {
    @Resource
    private DishMapper dishMapper;
    @Test
    public void addAllDish() {
        Dish dish = new Dish();
        dish.setBStatus(true);
        dish.setImg(1);
        dish.setMoney(BigDecimal.valueOf(12.2));
        dish.setName("111");
        dish.setPraise(BigDecimal.ONE);
        dish.setSale(0);
        dish.setShopId(1);
        dish.setSales(1);
        dish.setPraise(BigDecimal.ZERO);
        dish.setBActive(false);
        Dish dish1 = new Dish();
        dish1.setBStatus(true);
        dish1.setImg(1);
        dish1.setMoney(BigDecimal.valueOf(12.2));
        dish1.setName("112");
        dish1.setPraise(BigDecimal.ONE);
        dish1.setSale(0);
        dish1.setShopId(1);
        dish1.setSales(1);
        dish1.setPraise(BigDecimal.ZERO);
        dish1.setBActive(false);
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish);
        dishes.add(dish1);
        //dishMapper.addDish(dish);
        dishMapper.addAllDish(dishes);
    }
}