package com.richz.frame.exception;

public enum PrototypeErrorCode {

    SYSTEM_ERROR("110000","系统错误"),
    TOKEN_ERROR("770","无效签名"),
    TOKEN_TIME("771","token过期"),
    TOKEN_MATH("772","token算法不一致"),
    TOKEN_LOST("773","token失效"),
    USER_ABNORMAL("803","用户状态不正常"),

    ;
    private String code;
    private String message;

    PrototypeErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
