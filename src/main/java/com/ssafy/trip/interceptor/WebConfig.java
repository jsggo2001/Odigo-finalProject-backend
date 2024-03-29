package com.ssafy.trip.interceptor;

import listener.AppInitListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .allowedOrigins("http://localhost:9000","http://127.0.0.1:9000")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name());
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/hotplace/**")
                .excludePathPatterns("hotplace")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/user/issue")
                .excludePathPatterns("/travel/**")
                .excludePathPatterns("/map/**")
                .excludePathPatterns("/board/**")
                .excludePathPatterns("/comment/**");
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb
                = new ServletListenerRegistrationBean<>();

        srb.setListener(new AppInitListener());
        return srb;
    }
}
