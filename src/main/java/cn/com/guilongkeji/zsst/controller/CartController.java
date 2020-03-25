package cn.com.guilongkeji.zsst.controller;

import cn.com.guilongkeji.zsst.pojo.Cart;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import org.springframework.stereotype.Controller;

/**
 * @author : xgl
 * @date : 2020/3/22 14:51
 * @Description :
 */
@Controller
public class CartController {
    public Result addCart(Cart cart){
        return ResultFactory.buildSuccessResult("");
    }
}
