package cn.com.guilongkeji.zsst.utils;

import cn.com.guilongkeji.zsst.pojo.Record;

import java.util.Scanner;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/31
 */

public class ReCode {
    private final String MainCode = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public String getCode(){
        String code = "";
        for (int i=0;i < 6;i++){
            code+=MainCode.charAt((int) (Math.random()*61));
        }
        return code;
    }
    public boolean isCode(String code,String recode){
        return code.toUpperCase().equals(recode.toUpperCase().substring(0,6));
    }
}
