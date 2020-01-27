package cn.com.guilongkeji.zsst.config;

import cn.com.guilongkeji.zsst.utils.TencentSmsUtils;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public class TencentConfig extends TencentSmsUtils {
    private static final int APP_ID =1400283326;
    private static final String APP_KEY ="d9df7fbb4046c4bc6ade919f7ed2d0db";
    private static final int TEMPLATE_ID =468830;
    private static final String SMS_SIGN ="个人开发学习网";

    public TencentConfig() {
        this.setAppId(1);
        this.setAppKey("");
        this.setSmsSign("");
        this.setTemplateId(1);
    }

    @Override
    public void setAppId(int appId) {
        super.setAppId(APP_ID);
    }

    @Override
    public void setAppKey(String appKey) {
        super.setAppKey(APP_KEY);
    }

    @Override
    public void setTemplateId(int templateId) {
        super.setTemplateId(TEMPLATE_ID);
    }

    @Override
    public void setSmsSign(String smsSign) {
        super.setSmsSign(SMS_SIGN);
    }

    @Override
    public void setPhoneNumbers(String[] phoneNumbers) {
        phoneNumbers= new String[]{""+getCode().getPhone()};
        super.setPhoneNumbers(phoneNumbers);
    }

    @Override
    public void send() {
        setPhoneNumbers(new String[]{});
        super.send();
    }
}
