package cn.com.guilongkeji.zsst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */
@Controller
public class ResourceController {
    @RequestMapping("/getAllResource")
    public String getAllResource(){
        return "admin/admin/resource";
    }
}
