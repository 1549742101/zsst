package cn.com.guilongkeji.zsst.result;

import lombok.Data;

/**
 * @Description 响应码
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/4
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
