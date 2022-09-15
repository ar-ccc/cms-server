package com.arccc.cmsserver.interceptor;

import com.arccc.cmsserver.domain.User;
import com.arccc.cmsserver.exception.ExceptionEnum;
import com.arccc.cmsserver.exception.MyException;
import com.arccc.cmsserver.utils.JwtUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        user.remove();
    }

    public static final ThreadLocal<User> user = new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证token
        String token = request.getHeader("token");

        try {
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            ObjectMapper objectMapper = new ObjectMapper();
            User user1 = objectMapper.readValue(subject, new TypeReference<User>() {
            });
            user.set(user1);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.USER_NOT_LOGIN);
        }
    }

}
