package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */

@Mapper
public interface DishMapper {
    /**
     * 功能描述 增加菜品
     * @author xgl
     * @date 2020/1/28
      * @param dish
     * @return void
     */
    public void addDish(Dish dish);
    /**
     * 功能描述 批量增加菜品
     * @author xgl
     * @date 2020/1/28
      * @param dishes
     * @return void
     */
    public void addAllDish(List<Dish> dishes);
    /**
     * 功能描述  删除菜品
     * @author xgl
     * @date 2020/1/28
     * @param id
     * @return void
     */
    @Deprecated
    public void removeDish(Integer id);
    /**
     * 功能描述  删除菜品
     * @author xgl
     * @date 2020/1/28
     * @param ids
     * @return void
     */
    @Deprecated
    public void removeDishes(List<Integer> ids);
    /**
     * 功能描述 更新菜品
     * @author xgl
     * @date 2020/1/28
      * @param dish
     * @return void
     */
    public void updateDish(Dish dish);
    /**
     * 功能描述 批量更新菜品
     * @author xgl
     * @date 2020/1/28
      * @param dishes
     * @return void
     */
    public void updateAllDish(List<Dish> dishes);
    /**
     * 功能描述 获取所有菜品
     * @author xgl
     * @date 2020/1/28
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Dish>
     */
    public List<Dish> getAllDish();
    /**
     * 功能描述 根据店铺获取菜品
     * @author xgl
     * @date 2020/1/28
      * @param sid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Dish>
     */
    public List<Dish> getDishByShop(Integer sid);
    /**
     * 功能描述 根据菜品编号获取菜品
     * @author xgl
     * @date 2020/1/28
      * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Dish
     */
    public Dish getDishById(Integer id);
}