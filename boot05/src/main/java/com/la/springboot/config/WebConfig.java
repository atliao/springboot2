package com.la.springboot.config;

import com.la.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LA
 * @date 2022-09-20-17:17
 *
 * EnableWebMvc 全面接管 MVC:
 *   1.静态资源、视图解析器等等，所有springboot官方配置的东西全都失效
 *
 */
//@EnableWebMvc //全面接管 MVC
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
