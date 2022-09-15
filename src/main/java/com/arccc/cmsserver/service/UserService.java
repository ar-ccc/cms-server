package com.arccc.cmsserver.service;

import com.arccc.cmsserver.domain.User;
import com.arccc.cmsserver.vo.UserLoginOrRegistryVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
* @author dengxingda
* @description 针对表【user】的数据库操作Service
* @createDate 2022-09-12 15:23:28
*/
public interface UserService extends IService<User> {

    void registry(UserLoginOrRegistryVo vo);

    String login(UserLoginOrRegistryVo vo) throws JsonProcessingException;
}
