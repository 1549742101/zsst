package cn.com.guilongkeji.zsst.utils;

import cn.com.guilongkeji.zsst.config.TencentConfig;
import cn.com.guilongkeji.zsst.pojo.Code;

import java.util.Random;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public class TencentSms extends TencentConfig {
    public static void send(Code code){
        TencentConfig tencentConfig = new TencentConfig();
        tencentConfig.setCode(code);
        tencentConfig.send();
    }
    public static String random(){
        String random = "";
        Random random1 = new Random();
        for (int i=0;i < 6;i++){
            random+=random1.nextInt(10);
        }
        return random;
    }
}
