package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.service.ImgService;
import cn.com.guilongkeji.zsst.utils.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
@Controller
public class ImgController {
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Resource
    private ImgService imgService;
    @RequestMapping("getAllFile")
    public String getAllImg(Model model){
        model.addAttribute("allImg", FileSystem.getAllFileName(uploadFolder));
        return "img";
    }
    @RequestMapping(value = "/getImg")
    public String getImgById(Integer id){
        Img img = imgService.getImgById(id);
        return "redirect:/api/img/"+img.getUrl()+"/"+img.getName();
    }

}
