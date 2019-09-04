//package com.qgailab.filter;
//
//import org.apache.ibatis.io.Resources;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Properties;
//
///**
// * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
// * @description
// * @date 2019-07-30 07:54
// */
//@WebFilter(
//        filterName = "LoginFilter",
//        urlPatterns = {"/*"}, servletNames = {"/*"}
//)
//@Component
//public class LoginFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String uri = req.getRequestURI();
//        String contextPath = req.getContextPath();
//        String path = uri.substring(contextPath.length());
//        HttpSession sess;
//        sess = req.getSession();
//        //放行登陆注册
//        if (path.endsWith("login.html") || path.endsWith("image/login.html") ||
//                path.endsWith("js/login.js") || path.endsWith("css/login.css") ||
//                path.endsWith("/favicon.ico") || path.endsWith("js/tools.js") ||
//                path.endsWith("image/background.jpg")||path.endsWith("user/login")
//                ||path.endsWith("user/checkLogin")) {
//            filterChain.doFilter(req, resp);
//            return;
//        }
//        if (sess == null || sess.getAttribute("login") == null) {
//            if ("".equalsIgnoreCase(path) || "".equalsIgnoreCase(path) ||
//                    path.endsWith("logo.png") || path.endsWith(".js") || path.endsWith("css")) {
//                filterChain.doFilter(req, resp);
//                return;
//            } else {
//                //检查session是否有'login'属性,没有则重定向到登陆界面
//                if (sess == null || sess.getAttribute("login") == null) {
//                    req.getRequestDispatcher("/login.html").forward(req,resp);
//                    return;
//                }
//            }
//        }
//
//        filterChain.doFilter(req, resp);
//    }
//
//
//
//}
