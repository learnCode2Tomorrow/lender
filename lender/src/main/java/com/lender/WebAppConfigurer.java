package com.lender;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter
{
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new LendInterceptor()).addPathPatterns("/lender/**")
				.excludePathPatterns("/lender/loginCtrl/login", "/lender/registerCtrl/register");
		super.addInterceptors(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/page/login").setViewName("/static/page/login");
		super.addViewControllers(registry);
	}

	/**
	 * 配置静态访问资源
	 * 
	 * @param registry
	 */
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/css/**").addResourceLocations(
	 * "classpath:/static/css/");
	 * registry.addResourceHandler("/js/**").addResourceLocations(
	 * "classpath:/static/js/");
	 * registry.addResourceHandler("/page/**").addResourceLocations(
	 * "classpath:/static/page/"); super.addResourceHandlers(registry); }
	 */
}
