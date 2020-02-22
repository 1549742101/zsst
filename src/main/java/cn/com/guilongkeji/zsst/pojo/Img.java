package cn.com.guilongkeji.zsst.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/28
 */
@Data
public class Img {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String name;
    private String url;
    private String description;
    private Byte type;
    public void setBType(boolean type){
        Byte one = 1;
        Byte zero = 0;
        this.type=type?one:zero;
    }
    public boolean getBType(){
        return type.equals(1);
    }
}
