package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 数据库提取资源路径
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface ResourceMapper {
    /**
     * 功能描述 更新资源
     * @author xgl
     * @date 2020/1/13
      * @param resource
     * @return void
     */
    public void updateResource(Resource resource);
    /**
     * 功能描述 批量更新资源
     * @author xgl
     * @date 2020/1/13
      * @param resourceList
     * @return void
     */
    public void updateResources(List<Resource> resourceList);
    /**
     * 功能描述 插入资源
     * @author xgl
     * @date 2020/1/13
      * @param resource
     * @return void
     */
    public void addResource(Resource resource);
    /**
     * 功能描述 批量插入资源
     * @author xgl
     * @date 2020/1/13
      * @param resourcesList
     * @return void
     */
    public void addResources(List<Resource> resourcesList);
    /**
     * 功能描述 根据资源id获取资源
     * @author xgl
     * @date 2020/1/13
      * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Resource
     */
    public Resource getResourceById(Integer id);
    /**
     * 功能描述 根据权限获取资源
     * @author xgl
     * @date 2020/1/13
      * @param list
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Resource>
     */
    public List<Resource> getResourceByAll(List<Integer> list);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/9
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Resource>
     */
    public List<Resource> getAllResource();
}