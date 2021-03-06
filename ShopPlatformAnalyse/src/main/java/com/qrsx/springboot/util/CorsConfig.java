package com.qrsx.springboot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: CorsConfig
 * @Description: 跨域配置类
 * @date 2019年12月11日
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowCredentials(true).maxAge(3600);
	}
}
