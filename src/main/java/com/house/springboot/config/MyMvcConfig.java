package com.house.springboot.config;

import com.house.springboot.component.LoginHandlerInterceptor;
import com.house.springboot.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	@Value("${diskPath}")
	private String path;

	//注册视图控制启
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//浏览器发送/login 请求来到login页面
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/frame.html").setViewName("frame");
		registry.addViewController("/adminFrame.html").setViewName("adminFrame");
		registry.addViewController("/fangdongFrame.html").setViewName("fangdongFrame");
		registry.addViewController("/register.html").setViewName("register");
	}
	//注入区域信息Bean
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/index.html","/","/login","/static/**","/**/*.css","/**/*.js","/**/*.jpg","/**/*.png","/**/*.ico");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//  /home/file/**为前端URL访问路径  后面 file:xxxx为本地磁盘映射
		registry.addResourceHandler("/upload/**").addResourceLocations("file:" + path+"/upload/");
	}
}
