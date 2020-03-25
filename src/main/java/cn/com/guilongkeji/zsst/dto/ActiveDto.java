package cn.com.guilongkeji.zsst.dto;

import cn.com.guilongkeji.zsst.pojo.Active;
import cn.com.guilongkeji.zsst.pojo.Dish;
import cn.com.guilongkeji.zsst.pojo.Img;
import cn.com.guilongkeji.zsst.pojo.Shop;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActiveDto extends Active {
    private Img image;
    private Shop shop;
    private List<Dish> dishList;
    public ActiveDto(){

    }
    public ActiveDto(Active active){
        super();
        this.setId(active.getId());
        this.setName(active.getName());
        this.setCause(active.getCause());
        this.setEndTime(active.getEndTime());
        this.setBStatus(active.getBStatus());
        this.setStartTime(active.getStartTime());
        this.setTerm(active.getTerm());
        this.setShopId(active.getShopId());
        this.setImg(active.getImg());
    }

}
