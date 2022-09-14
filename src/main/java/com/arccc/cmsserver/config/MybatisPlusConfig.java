package com.arccc.cmsserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.arccc.cmsserver.mapper")
public class MybatisPlusConfig {
}
