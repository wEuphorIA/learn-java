package com.itheima.filter;

import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.io.IOException;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/9 下午4:14 */
// @WebFilter
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().contains("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = request.getHeader("token");

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        try {
            Claims claims = JwtUtils.parseJWT(token);
            Object id = claims.get("id");
            log.info("id:{}",id);
        } catch (Exception e) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }
}
