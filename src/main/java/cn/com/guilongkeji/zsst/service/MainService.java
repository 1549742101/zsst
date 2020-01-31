package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.*;

import java.util.List;

/**
 * @Description 公共服务
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/31
 */
public interface MainService {


    /**
     * 功能描述 增加图片
     * @author xgl
     * @date 2020/1/30
     * @param img
     * @return void
     */
    public void addImg(Img img);
    /**
     * 功能描述 更新图片
     * @author xgl
     * @date 2020/1/30
     * @param img
     * @return void
     */
    public void updateImg(Img img);
    /**
     * 功能描述 删除图片
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void removeImg(Integer id);
    /**
     * 功能描述 根据图片编号获取图片
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Img
     */
    public Img getImgById(Integer id);
    /**
     * 功能描述 根据所有图片编号获取图片
     * @author xgl
     * @date 2020/1/30
     * @param ids
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Img>
     */
    public List<Img> getImgByAllId(List<Integer> ids);



    /**
     * 功能描述 增加浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param record
     * @return void
     */
    public void addRecord(Record record);
    /**
     * 功能描述 增加浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param records
     * @return void
     */
    public void addAllRecord(List<Record> records);
    /**
     * 功能描述 更新浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param record
     * @return void
     */
    public void updateRecord(Record record);
    /**
     * 功能描述 更新浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param records
     * @return void
     */
    public void updateRecords(List<Record> records);
    /**
     * 功能描述 删除浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param ids
     * @return void
     */
    @Deprecated
    public void deleteRecords(List<Integer> ids);
    /**
     * 功能描述 删除浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void deleteRecord(Integer id);
    /**
     * 功能描述 根据用户编号获取浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Record>
     */
    public List<Record> getRecordByUserId(Integer uid);
    /**
     * 功能描述 获取所有浏览记录
     * @author xgl
     * @date 2020/1/30
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Record>
     */
    public List<Record> getAllRecord();



    /**
     * 功能描述 增加评价
     * @author xgl
     * @date 2020/1/28
     * @param assess
     * @return void
     */
    public void addAssess(Assess assess);
    /**
     * 功能描述 删除评价,彻底删除
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return void
     */
    @Deprecated
    public void removeAssess(Integer id);
    /**
     * 功能描述 更新评价
     * @author xgl
     * @date 2020/1/28
     * @param assess
     * @return void
     */
    public void updateAssess(Assess assess);
    /**
     * 功能描述 获取所有评价
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Assess>
     */
    public List<Assess> getAllAssess();
    /**
     * 功能描述 根据评价编号获取评价
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Assess
     */
    public Assess getAssessById(Integer id);
    /**
     * 功能描述 根据用户id获取评价详情
     * @author xgl
     * @date 2020/1/28
     * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Assess>
     */
    public List<Assess> getAssessByUserId(Integer uid);
    /**
     * 功能描述 根据订单获取评价
     * @author xgl
     * @date 2020/1/28
     * @param oid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Assess>
     */
    public List<Assess> getAssessByOrderId(Integer oid);
    /**
     * 功能描述 获取存活的评价
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Assess>
     */
    public List<Assess> getAssessByStatus();


    /**
     * 功能描述 增加活动
     * @author xgl
     * @date 2020/1/28
     * @param active
     * @return void
     */
    public void addActive(Active active);
    /**
     * 功能描述 批量增加活动
     * @author xgl
     * @date 2020/1/28
     * @param actives
     * @return void
     */
    public void addAllActive(List<Active> actives);
    /**
     * 功能描述 彻底删除活动，采用status设置false批量删除，用update方法
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return void
     */
    @Deprecated
    public void removeActive(Integer id);
    /**
     * 功能描述 批量彻底删除活动，采用status设置false批量删除，用update方法
     *      * @author xgl
     * @author xgl
     * @date 2020/1/28
     * @param ids
     * @return void
     */
    @Deprecated
    public void removeAllActive(List<Integer> ids);
    /**
     * 功能描述 获取所有的活动
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Active>
     */
    public List<Active> getAllActive();
    /**
     * 功能描述 根据店铺编号获取活动
     * @author xgl
     * @date 2020/1/28
     * @param shopId
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Active>
     */
    public List<Active> getActiveByShop(Integer shopId);
    /**
     * 功能描述 获取所有存活活动
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Active>
     */
    public List<Active> getActiveByStatus();
    /**
     * 功能描述 根据活动编号获取活动
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Active
     */
    public Active getActiveById(Integer id);
    /**
     * 功能描述 根据活动获取活动菜品
     * @author xgl
     * @date 2020/1/28
     * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Dish>
     */
    public List<Dish> getDishByActive();
    /**
     * 功能描述 更新活动方法
     * @author xgl
     * @date 2020/1/28
     * @param active
     * @return void
     */
    public void updateActive(Active active);
    /**
     * 功能描述 更新活动方法
     * @author xgl
     * @date 2020/1/28
     * @param active
     * @return void
     */
    public void updateAllActive(List<Active> active);



}
