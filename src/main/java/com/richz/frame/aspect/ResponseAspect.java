package com.richz.frame.aspect;

import com.richz.frame.entity.vo.ResponseData;
import com.richz.frame.util.MyUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ResponseAspect {

    @Around("execution(* com.richz.frame.controller..*(..))") // 根据包名调整
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前方法的签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String ReturnTypename = method.getReturnType().getName();
        // 检查方法的返回类型
        if (ReturnTypename.equals("void") ) {
            // 处理文件上传下载接口，直接返回结果
            return joinPoint.proceed();
        }

        // 调用目标方法并获取返回值
        Object result = joinPoint.proceed();

        // 对返回内容进行 XSS 过滤或其他处理
        String res = MyUtil.encodeParseJson(result);
        return new ResponseData(res);
    }
}
