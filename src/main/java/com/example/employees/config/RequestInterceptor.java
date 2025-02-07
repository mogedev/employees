package com.example.employees.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor  implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("Request: {} {}", request.getMethod(), request.getRequestURI());
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> logger.info("Header: {}: {}", headerName, request.getHeader(headerName)));
        return true;
    }
}
