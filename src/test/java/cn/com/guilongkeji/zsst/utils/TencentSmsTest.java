package cn.com.guilongkeji.zsst.utils;

import cn.com.guilongkeji.zsst.pojo.Code;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TencentSmsTest {

    @Test
    public void send() {
        Code code = new Code();
        code.setCode("999999");
        code.setPhone("17353165259");
        TencentSms.send(code);
    }
    @Test
    public void random(){

        System.out.println(TencentSms.random());
    }
}