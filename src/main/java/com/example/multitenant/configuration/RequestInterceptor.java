package com.example.multitenant.configuration;

import com.example.multitenant.mastertenant.config.DBContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestInterceptor extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tenantDBName = httpServletRequest.getHeader("X-tenant");

        Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

        logger.info("*****TENANT ID IS :"+tenantDBName);

        DBContextHolder.setCurrentDb(tenantDBName);

        filterChain.doFilter(httpServletRequest, response);
    }
}
