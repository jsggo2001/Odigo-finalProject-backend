package com.ssafy.trip.interceptor;

import listener.AppInitListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContextListener;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final JwtTokenInterceptor jwtTokenInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:9000");
//                .maxAge(3600); // 3600초 동안 preflight 결과를 캐시에 저장
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/travel/**");

    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb
                = new ServletListenerRegistrationBean<>();

        srb.setListener(new AppInitListener());
        return srb;
    }
}
