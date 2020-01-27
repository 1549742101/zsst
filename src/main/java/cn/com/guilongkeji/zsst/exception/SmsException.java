package cn.com.guilongkeji.zsst.exception;

import cn.com.guilongkeji.zsst.result.Result;
import lombok.Data;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
@Data
public class SmsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Result result;
    public SmsException(){
    }
    public SmsException(Result result){
        this.result=result;
    }
}
