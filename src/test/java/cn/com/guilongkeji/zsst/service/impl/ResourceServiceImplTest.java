package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.PocketCafeteriaApplication;
import cn.com.guilongkeji.zsst.dto.ResourceDto;
import cn.com.guilongkeji.zsst.service.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author XGL
 * @date 2020/3/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PocketCafeteriaApplication.class)
public class ResourceServiceImplTest {
    @Resource
    private ResourceService resourceService;
    @Test
    public void getResourceDto() {
        List<cn.com.guilongkeji.zsst.pojo.Resource> resources = resourceService.getAllResource();
        List<ResourceDto> list = resourceService.getResourceDto(resources);
        for (ResourceDto rd:list
             ) {
            System.out.println("父亲："+rd.getResource().getName()+"编号为："+rd.getResource().getId());
            for (cn.com.guilongkeji.zsst.pojo.Resource r:rd.getResourceList()
                 ) {
                System.out.println("儿子："+r.getName()+"编号为："+r.getId());
            }
        }
    }
}