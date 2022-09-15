package com.arccc.cmsserver.service.impl;

import com.arccc.cmsserver.domain.User;
import com.arccc.cmsserver.exception.ExceptionEnum;
import com.arccc.cmsserver.exception.MyException;
import com.arccc.cmsserver.service.UserService;
import com.arccc.cmsserver.mapper.UserMapper;
import com.arccc.cmsserver.utils.JwtUtil;
import com.arccc.cmsserver.vo.UserLoginOrRegistryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwt;
import org.springframework.stereotype.Service;

/**
* @author dengxingda
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-09-12 15:23:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

    @Override
    public void registry(UserLoginOrRegistryVo vo) {
        User name = baseMapper.selectOne(new QueryWrapper<User>().eq("name", vo.getUsername()));
        if (name!=null){
            throw new MyException(ExceptionEnum.USERNAME_EXIST);
        }

        User user = new User();
        user.setName(vo.getUsername());
        user.setPassword(vo.getPassword());
        baseMapper.insert(user);
    }

    @Override
    public String login(UserLoginOrRegistryVo vo) throws JsonProcessingException {
        User user = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("name", vo.getUsername())
                .eq("password", vo.getPassword()));
        if (user != null){
            //TODO 设置token
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writer().writeValueAsString(user);
            return JwtUtil.createJWT(s);
        }else {
            throw new MyException(ExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }
    }
}
