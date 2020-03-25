package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.ImgMapper;
import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.service.ImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Resource
    private ImgMapper imgMapper;
    @Override
    public void addImg(Img img) {
        imgMapper.addImg(img);
    }

    @Override
    public void updateImg(Img img) {
        imgMapper.updateImg(img);
    }

    @Override
    public void removeImg(Integer id) {
        imgMapper.removeImg(id);
    }

    @Override
    public Img getImgById(Integer id) {
        return imgMapper.getImgById(id);
    }

    @Override
    public List<Img> getImgByAllId(List<Integer> ids) {
        return imgMapper.getImgByAllId(ids);
    }

    @Override
    public List<Img> getImgByUrl(String url) {
        return imgMapper.getImgByUrl(url);
    }

    @Override
    public List<Img> search(Img img) {
        return null;
    }

    @Override
    public List<Img> sort(List<Img> list,Integer o) {
        return null;
    }
}
