package com.ss.data.common;

public enum ResultEnum {


    //业务类
    PARAM_IS_NULL(6),

    //请求类
    SUCCESS(0),//成功coed= 200
    ERROR(-1),//错误code = 500
    REQUEST_ERROR(1),//后端数据请求异常
    REQUEST_PARA_ERROR(2),
    REQUEST_NOT_LOGIN(3),//code=403权限不足
    REQUEST_BAD(4),//404
    ;
    private Integer code;

    private ResultEnum(Integer code) {
        this.code = code;
    }

    public int value() {

        return this.code;
    }
}
