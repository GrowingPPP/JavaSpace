package com.example.demo.config;

import com.example.demo.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WEB配置规则
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置拦截规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 多个拦截器组成一个拦截器链
         * addPathPatterns 用于添加拦截规则
         * excludePathPatterns 用户排除拦截,访问localhost:8080/toLogin时请求不会被拦截
         * /**下的所有请求会被拦截
         */
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 通过addResourceHandler添加映射路径
         * 通过addResourceLocations来指定路径
         * eg:
         * 将某一张图片(elephant.png)放置在/META-INF/resources/下,然后访问路由为http://localhost:8080/my/elephant.png
         */
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/META-INF/resources/");
        super.addResourceHandlers(registry);
    }
    /**
     * 配置页面跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
         * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.html页面了
         */
        registry.addViewController("/toLogin").setViewName("login.html");
        super.addViewControllers(registry);
    }
}
