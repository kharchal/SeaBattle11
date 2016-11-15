package ua.com.hav.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Converter implements Filter {
    private String charset;
    private String convertTo = "utf-8";

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        charset = servletRequest.getCharacterEncoding();
        servletRequest.setCharacterEncoding(convertTo);
        servletResponse.setCharacterEncoding(convertTo);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
