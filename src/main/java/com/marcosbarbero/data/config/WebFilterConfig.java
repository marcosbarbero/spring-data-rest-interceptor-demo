package com.marcosbarbero.data.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFilterConfig {

    private final DecryptHttpFilter decryptHttpFilter;

    public WebFilterConfig(DecryptHttpFilter decryptHttpFilter) {
        this.decryptHttpFilter = decryptHttpFilter;
    }

    @Bean
    public FilterRegistrationBean<DecryptHttpFilter> filterRegistrationBean() {
        FilterRegistrationBean<DecryptHttpFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(decryptHttpFilter);
        filterRegistrationBean.addUrlPatterns("/exams/search/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
