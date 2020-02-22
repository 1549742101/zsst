package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.SysResource;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 数据库提取资源路径
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface SysResourceMapper  {
    /**
     * 功能描述 更新资源
     * @author xgl
     * @date 2020/1/13
      * @param sysResource
     * @return void
     */
    public void updateSysResource(SysResource sysResource);
    /**
     * 功能描述 批量更新资源
     * @author xgl
     * @date 2020/1/13
      * @param sysResourceList
     * @return void
     */
    public void updateSysResources(List<SysResource> sysResourceList);
    /**
     * 功能描述 插入资源
     * @author xgl
     * @date 2020/1/13
      * @param sysResource
     * @return void
     */
    public void addSysResource(SysResource sysResource);
    /**
     * 功能描述 批量插入资源
     * @author xgl
     * @date 2020/1/13
      * @param sysResourcesList
     * @return void
     */
    public void addSysResources(List<SysResource> sysResourcesList);
    /**
     * 功能描述 根据资源id获取资源
     * @author xgl
     * @date 2020/1/13
      * @param id
     * @return cn.com.guilongkeji.zsst.pojo.SysResource
     */
    public SysResource getSysResourceById(Integer id);
    /**
     * 功能描述 根据权限获取资源
     * @author xgl
     * @date 2020/1/13
      * @param list
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysResource>
     */
    public List<SysResource> getSysResourceByAll(List<Integer> list);
    /**
     * 功能描述
     * @author xgl
     * @date 2020/2/9
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.SysResource>
     */
    public List<SysResource> getAllSysResource();
}