package com.hit.eryi.common.consts;

import com.hit.eryi.common.base.BaseEnum;

/**
 * 状态码
 */
public enum StatusCode implements BaseEnum {

    /**
     * 系统未知异常
     */
    SYS_UNKNOWN_ERROR(100000, "系统未知异常"),

    /**
     * 参数错误
     */
    SYS_PARAM_ERROR(100001, "参数错误"),

    /**
     * 用于远程调用时的系统出错
     */
    SYS_ISBUSY_NOW(100002, "系统繁忙"),

    /**
     * NOT FOUND
     */
    SYS_NOT_FOUND(100003, "未找到资源"),

    /**
     * ORDER_REPEAT
     */
    ORDER_REPEAT(100006, "单据重复"),

    /**
     * SERVICE ERROR
     */
    SYS_SERVICE_ERROR(100004, "服务端处理失败"),

    /**
     * 业务异常1
     */
    BIZ_ERROR1(200000, "业务操作失败1"),

    /**
     * 业务异常2
     */
    BIZ_ERROR2(200000, "业务操作失败2"),

    ;

    private Integer code;

    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
