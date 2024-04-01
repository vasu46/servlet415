package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageGenerator extends HttpServlet {
	//get 2nd Service Method in HttpServlet
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//Get PrintWriter to to write data into res obj destination
		PrintWriter pw=res.getWriter();
		//set Content type instruct to browser to res obj to write content in specified format
		res.setContentType("text/html");
		//write B.logic
		//Get LocalDateAND Time
		LocalDateTime ldt=LocalDateTime.now();
		//get Cuuret hour
		int hour=ldt.getHour();
		//wish message logic
		if(hour<12)
			pw.println("<b><h1 style='color:yellow;text-align:center'>Good Morning::vasu");
		else if(hour<16)
			pw.println("<b><h1 style='color:red;text-align:center'>Good OfterNoon::vasu");
		else if(hour<20)
			pw.println("<b><h1 style='color:blue;text-align:center'>Good Evening::vasu");
		else
			pw.println("<b><h1 style='color:pink;text-align:center'>Good Morning::vasu");
		  
		res.setHeader("refresh","10");
		//get hyperlink for home page
		   pw.println("<b><h3><a href='page.html'>get_Homepage</a></h3></b>");
		
		//close the streAM OBJ
		pw.close();
	}

}
