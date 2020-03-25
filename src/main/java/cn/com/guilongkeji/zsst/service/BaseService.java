package cn.com.guilongkeji.zsst.service;

import java.util.List;

/**
 * @author : xgl
 * @date : 2020/3/17 0:23
 * @Description  :
 */
public abstract interface BaseService<T>{

    /**
     * 查询方法
     * @param t
     * @return t
     */
    public abstract List<T> search(T t);

    /**
     * 排序方法
     * @param list,o 排序内容 排序方法
     * @return
     */
    public  List<T> sort(List<T> list,Integer o);
}
