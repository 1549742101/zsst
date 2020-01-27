package cn.com.guilongkeji.zsst.utils;

import cn.com.guilongkeji.zsst.exception.SmsException;
import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.result.Result;
import cn.com.guilongkeji.zsst.result.ResultFactory;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.Data;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *  @author xgl
 * Date: 2019/11/10
 * Time: 0:34
 * To change this template use File | Settings | File Templates.
 *
 **/
@Data
public class TencentSmsUtils {
    private int appId;
    private String appKey;
    private String[] phoneNumbers;
    private int templateId;
    private String smsSign;
    private Code code;
    public TencentSmsUtils() {
    }
    public void send(){
        try {
            String[] params = {code.getCode()};
            SmsMultiSender smsMultiSender = new SmsMultiSender(this.appId, this.appKey);
            /*SmsSingleSenderResult result = smsMultiSender.send(0, "86", config.getPhoneNumbers()[0],
                    "【"+config.getSmsSign()+"】"+params+"为你本次注册的验证码，如果非本人注册，请忽略此验证码", "", "");*/
            SmsMultiSenderResult result  = smsMultiSender.sendWithParam("86", this.phoneNumbers,
                    this.templateId, params, this.smsSign, "", "");

        } catch (HTTPException e) {
            // HTTP 响应码错误
            Result result = ResultFactory.buildFailResult("HTTP 响应码错误");
            new SmsException(result);
        } catch (JSONException e) {
            // JSON 解析错误
            Result result = ResultFactory.buildFailResult("JSON 解析错误");
            new SmsException(result);
        } catch (IOException e) {
            // 网络 IO 错误
            Result result = ResultFactory.buildFailResult("网络 IO 错误");
            new SmsException(result);
        }
    }
}
