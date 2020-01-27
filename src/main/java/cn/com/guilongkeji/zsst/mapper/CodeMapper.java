package cn.com.guilongkeji.zsst.mapper;

import cn.com.guilongkeji.zsst.pojo.Code;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface CodeMapper {
    public Code getCodeByPhone(String phone);
    public void insertCode(Code code);
}