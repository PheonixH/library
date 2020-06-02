package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: library
 * @className: WebConfig
 * @description: Interceptor config
 * @author: lov.moran
 * @date 2020-05-29 00:52
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        拦截器用于拦截所有请求
//        registry.addInterceptor(new LogInterceptor());
//
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/*");
//
//        拦截链接 “/admin/hello”，它将重定向到新的 “/admin/welcome”
//        registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/admin/hello");

//        拦截链接“/admin/*”，除了链接 “/admin/hello”
//        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/hello");
    }
}
