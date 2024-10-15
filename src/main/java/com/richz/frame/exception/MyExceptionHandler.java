package com.richz.frame.exception;



import com.richz.frame.entity.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData handleRRException(Exception e){
        log.warn("Exception:" + e.getMessage(), e);
        e.printStackTrace();
        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return ResponseData.error(myException.getCode(), myException.getMsg());
        }
        return ResponseData.error("500","系统异常，请联系管理员");
    }
}
