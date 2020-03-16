package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Shop;
import cn.com.guilongkeji.zsst.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */
@Controller
public class ShopController {
    @Resource
    private ShopService shopService;
    @RequestMapping("shop")
    public String getShop(@RequestParam(defaultValue = "-1") Integer id, Model model){
        List<Shop> shopList = new ArrayList<>();
        shopList= shopService.getAllShop();
        model.addAttribute(model);
        model.addAttribute("shop",shopList);
        return "app/shop";
    }
}
