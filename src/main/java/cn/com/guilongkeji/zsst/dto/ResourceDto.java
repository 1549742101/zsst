package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.Resource;
import lombok.Data;

import java.util.List;

/**
 * @author XGL
 * @date 2020/3/4
 */
@Data
public class ResourceDto {
    private Resource resource;
    private List<Resource> resourceList;
}
