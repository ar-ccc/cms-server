package com.arccc.cmsserver.mapper;

import com.arccc.cmsserver.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author dengxingda
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-09-12 15:23:28
* @Entity com.arccc.cmsserver.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
