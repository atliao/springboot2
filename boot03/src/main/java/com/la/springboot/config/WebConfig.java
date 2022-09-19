package com.la.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author LA
 * @date 2022-09-18-17:52
 * 自定义RestFul名称
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig  /*方式一：继承接口*/ /*implements WebMvcConfigurer*/ {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    //重写路径规则
    /*
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);//取消自动移除分号(;)的功能，此时矩阵变量才能获取
        configurer.setUrlPathHelper(urlPathHelper);
    }
    */

    //方式二：添加组件
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);//取消自动移除分号(;)的功能，此时矩阵变量才能获取
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
}
