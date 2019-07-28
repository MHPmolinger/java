package com.rbac.config;

import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
//@MapperScan(basePackages= {"com.rbac.mapper"}) //spring 扫描接口
@MapperScan(basePackages= {"com.rbac.mapper"})
public class MybatisConfig {

	
}
