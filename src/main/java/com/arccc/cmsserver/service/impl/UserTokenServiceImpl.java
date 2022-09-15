package com.arccc.cmsserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arccc.cmsserver.domain.UserToken;
import com.arccc.cmsserver.service.UserTokenService;
import com.arccc.cmsserver.mapper.UserTokenMapper;
import org.springframework.stereotype.Service;

/**
* @author dengxingda
* @description 针对表【user_token】的数据库操作Service实现
* @createDate 2022-09-15 17:08:30
*/
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken>
    implements UserTokenService{

}




