package com.example.fake_hotell.controller;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// Tiếng Việt

@WebFilter("/*")
public class UnicodeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo filter (nếu cần)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Dọn dẹp tài nguyên (nếu cần)
    }
}