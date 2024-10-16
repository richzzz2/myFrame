package com.richz.frame.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richz.frame.entity.vo.ResponseData;
import com.richz.frame.exception.PrototypeErrorCode;

import com.richz.frame.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.web.servlet.HandlerInterceptor;


import java.util.HashMap;
import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseData res = new ResponseData();
        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("token");
        try{
            JwtUtil.verify(token);//验证令牌
            return true;//放行请求
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            res.setMsg(PrototypeErrorCode.TOKEN_ERROR.getMessage());
            res.setResult_code(PrototypeErrorCode.TOKEN_ERROR.getCode());
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            res.setMsg(PrototypeErrorCode.TOKEN_TIME.getMessage());
            res.setResult_code(PrototypeErrorCode.TOKEN_TIME.getCode());
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            res.setMsg( PrototypeErrorCode.TOKEN_MATH.getMessage());
            res.setResult_code(PrototypeErrorCode.TOKEN_MATH.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg(PrototypeErrorCode.TOKEN_LOST.getMessage());
            res.setResult_code(PrototypeErrorCode.TOKEN_LOST.getCode());
        }
        //将map转化成json，response使用的是Jackson
        String json = new ObjectMapper().writeValueAsString(res);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}
