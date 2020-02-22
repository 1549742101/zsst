package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.dto.ActiveDto;
import cn.com.guilongkeji.zsst.mapper.ActiveMapper;
import cn.com.guilongkeji.zsst.mapper.DishMapper;
import cn.com.guilongkeji.zsst.mapper.ImgMapper;
import cn.com.guilongkeji.zsst.mapper.ShopMapper;
import cn.com.guilongkeji.zsst.pojo.Active;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.service.ActiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description 活动
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */
@Service
public class ActiveServiceImpl implements ActiveService {
    @Resource
    private ActiveMapper activeMapper;
    @Resource
    private ImgMapper imgMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private DishMapper dishMapper;
    @Override
    public void addActive(Active active) {
        activeMapper.addActive(active);
    }

    @Override
    public void addAllActive(List<Active> actives) {
        activeMapper.addAllActive(actives);
    }

    @Override
    public void removeActive(Integer id) {
        activeMapper.removeActive(id);
    }

    @Override
    public void removeAllActive(List<Integer> ids) {
        activeMapper.removeAllActive(ids);
    }

    @Override
    public List<Active> getAllActive() {
        return activeMapper.getAllActive();
    }

    @Override
    public List<Active> getActiveByShop(Integer shopId) {
        return activeMapper.getActiveByShop(shopId);
    }

    @Override
    public List<Active> getActiveByStatus() {
        return activeMapper.getActiveByStatus();
    }

    @Override
    public Active getActiveById(Integer id) {
        return activeMapper.getActiveById(id);
    }

    @Override
    public List<Dish> getDishByActive() {
        return activeMapper.getDishByActive();
    }

    @Override
    public void updateActive(Active active) {
        activeMapper.updateActive(active);
    }

    @Override
    public void updateAllActive(List<Active> active) {
        activeMapper.updateAllActive(active);
    }

    @Override
    public ActiveDto getActiveByActive(Active active) {
        ActiveDto activeDto = new ActiveDto(active);
        activeDto.setDishList(dishMapper.getDishByShop(active.getShopId()));
        activeDto.setImage(imgMapper.getImgById(active.getImg()));
        activeDto.setShop(shopMapper.getShopById(active.getId()));
        return activeDto;
    }

    @Override
    public List<Active> getHotsActive() {
        List<Active> activeList = activeMapper.getHotsActive();
        while (activeList.size()<4){
            Active active = new Active();
            active.setBStatus(false);
            active.setStartTime(new Date());
            active.setName("暂无活动");
        }
        return activeList;
    }
}
