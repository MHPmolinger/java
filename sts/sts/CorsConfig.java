package com.rbac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决浏览器跨域访问问题
 * 在B应用端开启支持跨域请求
 */
@Configuration //告诉springboot  启动时 加载本类
public class CorsConfig {

	/**
	 * 告诉springboot 具体做什么
	 */
	@Bean //初始化一个bean  存入spring的IOC容器
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 设置了可以被跨域访问的路径和可以被哪些主机跨域访问
//                registry.addMapping("/api/**").allowedOrigins("http://localhost:8081", "http://localhost:8082");
            	registry.addMapping("/**").allowedOrigins("http://localhost");
            }
        };
    }
}
