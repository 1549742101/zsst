package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.SysResourceMapper;
import cn.com.guilongkeji.zsst.pojo.SysResource;
import cn.com.guilongkeji.zsst.service.SysResourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public class SysResourceServiceImpl implements SysResourceService {
    @Resource
    private SysResourceMapper sysResourceMapper;
    @Override
    public void updateSysResource(SysResource sysResource) {
        sysResourceMapper.updateSysResource(sysResource);
    }

    @Override
    public void updateSysResources(List<SysResource> sysResourceList) {
        sysResourceMapper.updateSysResources(sysResourceList);
    }

    @Override
    public void addSysResource(SysResource sysResource) {
        sysResourceMapper.addSysResource(sysResource);
    }

    @Override
    public void addSysResources(List<SysResource> sysResourcesList) {
        sysResourceMapper.addSysResources(sysResourcesList);
    }

    @Override
    public SysResource getSysResourceById(Integer id) {
        return sysResourceMapper.getSysResourceById(id);
    }

    @Override
    public List<SysResource> getSysResourceByAll(List<Integer> list) {
        return sysResourceMapper.getSysResourceByAll(list);
    }

    @Override
    public List<SysResource> getAllSysResource() {
        return sysResourceMapper.getAllSysResource();
    }
}
