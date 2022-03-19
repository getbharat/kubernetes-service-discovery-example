package com.ecom.order.filter;

import com.ecom.order.config.CustomHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class RequestModifyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final CustomHttpServletRequestWrapper customHttpServletRequestWrapper = new CustomHttpServletRequestWrapper(((HttpServletRequest) request));
        chain.doFilter(customHttpServletRequestWrapper,response);
    }
}
