package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 店铺
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface ShopMapper{
    /**
     * 功能描述 增加店铺
     * @author xgl
     * @date 2020/1/30
      * @param shop
     * @return void
     */
    public void addShop(Shop shop);
    /**
     * 功能描述 批量增加店铺
     * @author xgl
     * @date 2020/1/30
      * @param shops
     * @return void
     */
    public void addAllShop(List<Shop> shops);
    /**
     * 功能描述 更新店铺信息
     * @author xgl
     * @date 2020/1/30
      * @param shop
     * @return void
     */
    public void updateShop(Shop shop);
    /**
     * 功能描述 更新店铺信息
     * @author xgl
     * @date 2020/1/30
      * @param shops
     * @return void
     */
    public void updateShops(List<Shop> shops);
    /**
     * 功能描述 删除店铺
     * @author xgl
     * @date 2020/1/30
      * @param id
     * @return void
     */
    @Deprecated
    public void removeShop(Integer id);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/1/30
      * @param ids
     * @return void
     */
    @Deprecated
    public void removeShops(List<Integer> ids);
    /**
     * 功能描述 获取店铺
     * @author xgl
     * @date 2020/1/30
      * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Shop
     */
    public Shop getShopById(Integer id);
    /**
     * 功能描述 获取店铺
     * @author xgl
     * @date 2020/1/30
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Shop>
     */
    public List<Shop> getAllShop();

}