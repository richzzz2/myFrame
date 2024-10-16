package com.richz.frame.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.richz.frame.aspect.annotation.LogAnnotation;
import com.richz.frame.util.IPUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(logAnnotation)")
    public Object saveLog(ProceedingJoinPoint joinPoint, LogAnnotation logAnnotation){
        JSONObject jsonObject = new JSONObject();
        Object[] args = joinPoint.getArgs();
        jsonObject.put("args",args);
        String token = request.getHeader("token");
        String ipAddress = IPUtil.getIpAddr(request);
        String logType = logAnnotation.logType();
        System.out.println("参数map："+jsonObject.toString());
        System.out.println("logType："+logType);
        System.out.println("ipAddress："+ipAddress);
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
