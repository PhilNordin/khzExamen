package com.philip.khzExamen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class AppWebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/order").setViewName("order-page");
        registry.addViewController("/admin").setViewName("admin-page");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**", "/static/**")
                .addResourceLocations("/resources/", "classpath:/static/");
    }

}