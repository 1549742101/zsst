package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.SysResource;


import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public interface SysResourceService {
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
