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
    /**
     * 功能描述 根据电话号码获取验证码
     * @author xgl
     * @date 2020/1/27
      * @param phone
     * @return cn.com.guilongkeji.zsst.pojo.Code
     */
    public Code getCodeByPhone(String phone);
    /**
     * 功能描述 插入验证码
     * @author xgl
     * @date 2020/1/27
      * @param code
     * @return void
     */
    public void insertCode(Code code);
}