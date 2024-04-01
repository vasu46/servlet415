package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set Conetnt Ty[pe
		res.setContentType("text/html");
		//get Browser
		String browser=req.getHeader("user-agent");
		System.out.println(browser);
		if(browser.contains("Chrome")) {
			chain.doFilter(req,res);
		   }
		else {
			pw.println("<h1 style='color:red;text-align:center'>Request Must Be Given by Chrome Browser");
			return;
		}
		//close Stream
		pw.close();
	}//doFilter

}//BrowserCheckFiletr
