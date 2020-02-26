package cn.com.guilongkeji.zsst.utils;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
    public static List<Integer> StringToList(String arg){
        List<Integer> list = new ArrayList<>();
        for (String s:arg.split(",")){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    public static String ListToString(List<Integer> list){
        String s = "";
        for (Integer i:list){
            s+=","+i;
        }
        if (s.startsWith(",")){
            s.substring(1,s.length());
        }
        return s;
    }
    public static boolean oneEquals(String s1,String s2){
        return s1.contains(s2);
    }
}
