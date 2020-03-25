package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Shop;
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
 * @Date 2020/2/4
 */
@Controller
@SessionAttributes({"menuUrl","username"})
@RequestMapping("/app")
public class ShopController {
    @Resource
    private ShopService shopService;
    @RequestMapping("shop")
    public String getShop(@RequestParam(defaultValue = "-1") Integer id,
                          @ModelAttribute("menuUrl") HashMap<String,String> menuUrl,
                          Model model, @ModelAttribute("username")String username,
                          @RequestParam(defaultValue = "")String name,@RequestParam(defaultValue = "1") Integer sort){
        List<Shop> shopList;
        if (id==-1){
            if (StringUtils.isNotEmpty(name)){
                Shop shop = new Shop();
                shop.setName(name);
                shopList = shopService.search(shop);
            }else {
                shopList= shopService.getAllShop();
            }
            shopList = shopService.sort(shopList,sort);
        }else {
            shopList = new ArrayList<>();
            shopList.add(shopService.getShopById(id));
        }
        model.addAttribute("menuUrl",menuUrl);
        model.addAttribute("username",username);
        model.addAttribute("shop",shopList);
        return "app/shop";
    }
}
