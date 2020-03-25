package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.dto.ResourceDto;
import cn.com.guilongkeji.zsst.mapper.ResourceMapper;
import cn.com.guilongkeji.zsst.pojo.Resource;
import cn.com.guilongkeji.zsst.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;
    @Override
    public void updateResource(Resource resource) {
        resourceMapper.updateResource(resource);
    }

    @Override
    public void updateResources(List<Resource> resourceList) {
        resourceMapper.updateResources(resourceList);
    }

    @Override
    public void addResource(Resource resource) {
        resourceMapper.addResource(resource);
    }

    @Override
    public void addResources(List<Resource> resourcesList) {
        resourceMapper.addResources(resourcesList);
    }

    @Override
    public Resource getResourceById(Integer id) {
        return resourceMapper.getResourceById(id);
    }

    @Override
    public List<Resource> getResourceByAll(List<Integer> list) {
        return resourceMapper.getResourceByAll(list);
    }

    @Override
    public List<Resource> getAllResource() {
        return resourceMapper.getAllResource();
    }
    @Override
    public List<ResourceDto> getResourceDto(List<Resource> allResource){
        List<ResourceDto> list = new ArrayList<>();
        for (Resource r:allResource
             ) {
            ResourceDto rd = new ResourceDto();
            if (r.getParentId()==null){
                rd.setResource(r);
                rd.setResourceList(getChild(allResource,r));
                list.add(rd);
            }
        }
        Collections.sort(list, (o1, o2) -> o1.getResource().getPriority().compareTo(o2.getResource().getPriority()));
        return list;
    }
    private List<Resource> getChild(List<Resource> list,Resource parent){
        List<Resource> list1=new ArrayList<>();
        for (Resource r:list
             ) {
            if (parent.getId().equals(r.getParentId())){
                list1.add(r);
            }
        }
        Collections.sort(list1,new Comparator<Resource>(){
            @Override
            public int compare(Resource o1, Resource o2) {
                return o1.getPriority().compareTo(o2.getPriority());
            }
        });
        return list1;
    }

    @Override
    public List<Resource> search(Resource resource) {
        return null;
    }

    @Override
    public List<Resource> sort(List<Resource> list,Integer o) {
        return null;
    }
}
