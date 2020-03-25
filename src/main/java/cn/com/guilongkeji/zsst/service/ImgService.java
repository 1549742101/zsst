package cn.com.guilongkeji.zsst.service;

import cn.com.guilongkeji.zsst.pojo.Img;

import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
public interface ImgService extends BaseService<Img>{
    /**
     * 功能描述 增加图片
     * @author xgl
     * @date 2020/1/30
     * @param img
     * @return void
     */
    public void addImg(Img img);
    /**
     * 功能描述 更新图片
     * @author xgl
     * @date 2020/1/30
     * @param img
     * @return void
     */
    public void updateImg(Img img);
    /**
     * 功能描述 删除图片
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return void
     */
    @Deprecated
    public void removeImg(Integer id);
    /**
     * 功能描述 根据图片编号获取图片
     * @author xgl
     * @date 2020/1/30
     * @param id
     * @return cn.com.guilongkeji.zsst.pojo.Img
     */
    public Img getImgById(Integer id);
    /**
     * 功能描述 根据所有图片编号获取图片
     * @author xgl
     * @date 2020/1/30
     * @param ids
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Img>
     */
    public List<Img> getImgByAllId(List<Integer> ids);
    /**
     * 功能描述 根据功能模块获取图片
     * @author xgl
     * @date 2020/2/1
     * @param url
     * @return
     */
    public List<Img> getImgByUrl(String url);
}
