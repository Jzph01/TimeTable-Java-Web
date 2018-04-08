package com.enjoyyourtime.app.configuration;


import com.enjoyyourtime.app.interceptors.IPInterceptor;
import com.enjoyyourtime.app.interceptors.VisitedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

    private final IPInterceptor ipInterceptor;
    private final VisitedInterceptor visitedInterceptor;

    @Autowired
    public InterceptorsConfig(IPInterceptor ipInterceptor, VisitedInterceptor visitedInterceptor) {
        this.ipInterceptor = ipInterceptor;
        this.visitedInterceptor = visitedInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.ipInterceptor).addPathPatterns("/");
        registry.addInterceptor(this.visitedInterceptor).addPathPatterns("/");
    }

}
