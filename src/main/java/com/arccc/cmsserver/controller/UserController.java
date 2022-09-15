package com.arccc.cmsserver.controller;

import com.arccc.cmsserver.exception.ExceptionEnum;
import com.arccc.cmsserver.exception.MyException;
import com.arccc.cmsserver.service.UserService;
import com.arccc.cmsserver.utils.Result;
import com.arccc.cmsserver.vo.UserLoginOrRegistryVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registry")
    public Result registry(@RequestBody UserLoginOrRegistryVo vo){
        userService.registry(vo);
        return Result.ok("注册成功");
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginOrRegistryVo vo) throws JsonProcessingException {
        String token = userService.login(vo);
        Map<String ,String > map = new HashMap<>();
        map.put("token",token);
        return Result.ok().data(map);
    }
    @GetMapping("/isLogin")
    public Result isLogin(){

        return Result.ok();
    }




}
