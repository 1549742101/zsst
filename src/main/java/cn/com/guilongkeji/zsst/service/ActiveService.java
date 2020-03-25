package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.dto.ActiveDto;
import cn.com.guilongkeji.zsst.pojo.Active;
import cn.com.guilongkeji.zsst.pojo.Dish;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */
public interface ActiveService extends BaseService<Active>{
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
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/10
      * @param  active
     * @return cn.com.guilongkeji.zsst.dto.ActiveDto
     */
    public ActiveDto getActiveByActive(Active active);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/10
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Active>
     */
    public List<Active> getHotsActive();
}
