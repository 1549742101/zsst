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
}
