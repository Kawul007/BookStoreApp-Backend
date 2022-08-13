package com.Kawul.BookStoreApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web 配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/";


    /**
     * 配置添加拦截器，拦截是否登录以及角色权限
     *
     * @param registry
     */

    /**
     * 配置允许跨域
     *
     * @param registry
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .allowedOrigins("*");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + UPLOADED_FOLDER);
    }
}