package com.richz.frame.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{
    private String code = "500";
    private String msg = "服务异常";
    public MyException(PrototypeErrorCode prototypeErrorCode){
        super();
        this.code = prototypeErrorCode.getCode();
        this.msg = prototypeErrorCode.getMessage();
    }
}
