package com.ecom.customer.filter;

import com.ecom.customer.config.CustomHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
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
