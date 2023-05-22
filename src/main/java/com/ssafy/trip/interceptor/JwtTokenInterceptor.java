package com.ssafy.trip.interceptor;

import com.ssafy.trip.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@CrossOrigin
public class JwtTokenInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //preflight요청이 날라오는 경우 cors에러 발생 대처 코드
        if (isPreflightRequest(request)) {
            return true;
        }
        
        System.out.println("JwtToken 호출");
        String accessToken = request.getHeader("Access_token");
        System.out.println("AccessToken:" + accessToken);
        String refreshToken = request.getHeader("Refresh_token");
        System.out.println("RefreshToken:" + refreshToken);

        if (accessToken != null && jwtTokenProvider.isValidAccessToken(accessToken)) {
            return true;
        }

        response.setStatus(401);
        if (jwtTokenProvider.isValidAccessToken(accessToken) == false) {
            response.setStatus(403);
        } else {
            response.setStatus(401);
        }
        response.setHeader("ACCESS_TOKEN", accessToken);
        response.setHeader("REFRESH_TOKEN", refreshToken);
        response.setHeader("msg", "Check the tokens.");
        return false;
    }



    private boolean isPreflightRequest(HttpServletRequest request) {
        return isOptions(request) && hasHeaders(request) && hasMethod(request) && hasOrigin(request);
    }

    private boolean isOptions(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString());
    }

    private boolean hasHeaders(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Access-Control-Request-Headers"));
    }

    private boolean hasMethod(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Access-Control-Request-Method"));
    }

    private boolean hasOrigin(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Origin"));
    }
}
