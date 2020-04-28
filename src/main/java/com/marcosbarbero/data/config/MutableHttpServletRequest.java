package com.marcosbarbero.data.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class MutableHttpServletRequest extends HttpServletRequestWrapper {

    private Map<String, String[]> parameters = new HashMap<>();

    public MutableHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public void setParameter(String name, String value) {
        parameters.put(name, new String[]{value});
    }

    @Override
    public String getParameter(String name) {
        if (parameters.get(name) != null) {
            return parameters.get(name)[0];
        }
        HttpServletRequest req = (HttpServletRequest) super.getRequest();
        return req.getParameter(name);
    }

    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> result = new HashMap<>();
        result.putAll(super.getRequest().getParameterMap());
        result.putAll(parameters);
        return Collections.unmodifiableMap(result);
    }

    public Enumeration<String> getParameterNames() {
        Set<String> result = new HashSet<>(Collections.list(super.getRequest().getAttributeNames()));
        result.addAll(parameters.keySet());
        return new Vector<>(result).elements();
    }

    public String[] getParameterValues(String name) {
        if (parameters.get(name) != null) {
            return parameters.get(name);
        }
        HttpServletRequest req = (HttpServletRequest) super.getRequest();
        return req.getParameterValues(name);
    }
}
