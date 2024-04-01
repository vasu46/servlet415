package com.nt.filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PerformanceFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
    		throws IOException, ServletException {
    	long startTime=0,endTime=0;
    	startTime=System.currentTimeMillis();
    	chain.doFilter(req, res);
    	endTime=System.currentTimeMillis();
    	System.out.println(req.getRequestURI()+"has Taken "+(endTime-startTime)+"ms to process The request");
    	
    }
}
