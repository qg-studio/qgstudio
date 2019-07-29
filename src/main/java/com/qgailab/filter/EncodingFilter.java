package com.qgailab.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 14:56
 */
@WebFilter(
        filterName = "EncodingFilter",
        urlPatterns = {"/*"}, servletNames = {"/*"},
        initParams = {
                @WebInitParam(name = "ENCODING", value = "UTF-8")
        }
)
@Slf4j
public class EncodingFilter extends OncePerRequestFilter {
    private final String ENCODING = "UTF-8";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            httpServletRequest.setCharacterEncoding(ENCODING);
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.setCharacterEncoding(ENCODING);
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.addHeader("Access-Control-Allow-Headers",
                    "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "*");
            httpServletResponse.addHeader("Access-Control-Max-Age", "100");
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "false");

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}

