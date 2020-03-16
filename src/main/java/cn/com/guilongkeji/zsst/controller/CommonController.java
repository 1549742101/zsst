package cn.com.guilongkeji.zsst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author XGL
 */
@Controller
@RequestMapping("common")
public class CommonController {
    @RequestMapping("found")
    public String found(){
        return "common/found";
    }
    @RequestMapping("notPermission")
    public String notPermission(){
        return "common/notPermission";
    }
}
