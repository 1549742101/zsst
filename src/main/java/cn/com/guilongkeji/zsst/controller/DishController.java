package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Shop;
import cn.com.guilongkeji.zsst.service.DishService;
import cn.com.guilongkeji.zsst.service.ShopService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
@Controller
@RequestMapping("/app")
@SessionAttributes({"menuUrl","username"})
public class DishController {
    @Resource
    private DishService dishService;
    @Resource
    private ShopService shopService;
    @RequestMapping("/findDish")
    public String findDish(@ModelAttribute("username")String username, Model model,
                           @ModelAttribute("menuUrl")HashMap<String,String> menuUrl,
                           @RequestParam(defaultValue = "-1") Integer id,
                           @RequestParam(defaultValue = "")String name,
                           @RequestParam(defaultValue = "")String shopName,
                           @RequestParam(defaultValue = "1") Integer sort){
        List<Dish> dishList;
        if (id==-1){
            dishList = new ArrayList<>();
            if (StringUtils.isNotEmpty(name)){
                Dish dish = new Dish();
                dish.setName(name);
                dishService.search(dish);
            }
            if (StringUtils.isNotEmpty(shopName)){
                Shop shop = new Shop();
                shop.setName(shopName);
                List<Shop> shopList=shopService.search(shop);
                for (Shop shop1 : shopList){
                    dishList.addAll(dishService.getDishByShop(shop1.getId()));
                }
            }
            if (StringUtils.isEmpty(shopName)&&StringUtils.isEmpty(name)){
                dishList = dishService.getAllDish();
            }
            dishList=dishService.sort(dishList,sort);
        }else {
            dishList = new ArrayList<>();
            Dish dish = dishService.getDishById(id);
            dishList.add(dish);
        }
        model.addAttribute("dishList",dishList);
        model.addAttribute("menuUrl",menuUrl);
        model.addAttribute("username",username);
        return "app/findDish";
    }
}
