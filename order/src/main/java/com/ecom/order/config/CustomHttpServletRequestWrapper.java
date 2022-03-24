package com.ecom.order.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    private HttpServletRequest _getHttpServletRequest() {
        return (HttpServletRequest) super.getRequest();
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        if(name.equalsIgnoreCase("Accept")){
            return Collections.enumeration(Arrays.asList("application/json","application/xml", "text/xml"));
        }
        return this._getHttpServletRequest().getHeaders(name);
    }

}
