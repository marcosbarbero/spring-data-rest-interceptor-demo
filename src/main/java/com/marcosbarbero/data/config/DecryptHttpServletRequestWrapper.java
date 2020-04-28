package com.marcosbarbero.data.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

public class DecryptHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest wrapped;

    private Map<String, String[]> parameterMap;

    public DecryptHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
}
