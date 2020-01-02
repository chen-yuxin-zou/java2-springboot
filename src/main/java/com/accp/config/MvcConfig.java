package com.accp.config;

import com.accp.intercetor.Intercetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*@Configuration*/
public class MvcConfig extends WebMvcConfigurationSupport {

   /* @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:static");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").allowCredentials(true);
        super.addCorsMappings(registry);
    }

    @Override
    protected  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new Intercetor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }*/
}
