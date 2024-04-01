package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {
	 @Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set Content Type
		 res.setContentType("text/html");
		 //get System data and Timne
		 LocalDateTime ldt=LocalDateTime.now();
		 //get Courrent Hour
		 int hour=ldt.getHour();
		 if(hour>=9 && hour<=17)
			 chain.doFilter(req, res);//execute next Fileter or destination Web Comp
		 else {
			 pw.println("<h1 style='color:red;text-align:center'>Request Must Be Given By 9AM to 5 PM");
		    return;
		 }
		 
		//cose Stream
		 pw.close();
	}//doFiletr
	

}//TimeFiletrCheck
