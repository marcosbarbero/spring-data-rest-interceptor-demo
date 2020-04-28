package com.marcosbarbero.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DecryptHttpFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(DecryptHttpFilter.class);

    private static final String PARAM_NAME = "customerId";

    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(httpServletRequest);

        logger.info(mutableRequest.getRequestURI());
        logParamValue(mutableRequest);

        // do your decrypt thing here
        mutableRequest.setParameter(PARAM_NAME, "100");

        logParamValue(mutableRequest);

        filterChain.doFilter(mutableRequest, httpServletResponse);
    }

    private void logParamValue(MutableHttpServletRequest request) {
        logger.info("{}={}", PARAM_NAME, request.getParameter(PARAM_NAME));
    }

}
