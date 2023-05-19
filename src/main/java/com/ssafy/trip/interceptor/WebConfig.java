package com.ssafy.trip.interceptor;

import listener.AppInitListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContextListener;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

//    private final JwtTokenInterceptor jwtTokenInterceptor;
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/**");
//
//        //excludePathPatterns(); 으로 뚤릴 패스 정의
//    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb
                = new ServletListenerRegistrationBean<>();

        srb.setListener(new AppInitListener());
        return srb;
    }
}
