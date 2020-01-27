package cn.com.guilongkeji.zsst.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SystemTimeTest {

    @Test
    public void test() {


        SystemTime systemTime = new SystemTime();
        Thread t = new Thread(systemTime);
        systemTime.start();
        t.start();
    }

    public static void main(String[] args) {
        SystemTime systemTime = new SystemTime();
        systemTime.start();
        System.out.println(systemTime.t);
    }
}