package com.marcosbarbero.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DecryptHttpFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(DecryptHttpFilter.class);

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    private static final String PARAM_NAME = "customerId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);

        logger.info(mutableRequest.getRequestURI());
        logParamValue(mutableRequest);

        // do your decrypt thing here
        mutableRequest.setParameter(PARAM_NAME, "100");

        logParamValue(mutableRequest);

        filterChain.doFilter(mutableRequest, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !PATH_MATCHER.match("/*/search/*", request.getRequestURI().toLowerCase());
    }

    private void logParamValue(MutableHttpServletRequest request) {
        logger.info("{}={}", PARAM_NAME, request.getParameter(PARAM_NAME));
    }
}
