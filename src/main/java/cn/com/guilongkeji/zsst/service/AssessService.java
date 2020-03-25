package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.Assess;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */
public interface AssessService extends BaseService<Assess>{
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
}
