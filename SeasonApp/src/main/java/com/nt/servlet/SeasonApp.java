package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class SeasonApp extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//printwrietr
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//b.logic
		//get LoaclDtae Time
		LocalDateTime ldt=LocalDateTime.now();
		//get Current Month
		int mounth=ldt.getMonthValue();
		//season finer
		if(mounth<3)
			pw.println("<b><h1 style='color:green;text-align:center'>Winter Season::vasu</h1></b>");
		else if(mounth<7)
			pw.println("<b><h1 style='color:red;text-align:center'>Summer Season::vasu</h1></b>");
		else if(mounth<9)
			pw.println("<b><h1 style='color:blue;text-align:center'>Rainy Season::vasu</h1></b>");
		else
			pw.println("<b><h1 style='color:red;text-align:center'>Spring Season::vasu</h1></b>");
		
		//get hyperlink for home page
		   pw.println("<b><h3><a href='page.html'>get_Homepage</a></h3></b>");
		
		//close the streAM OBJ
		pw.close();
		
	}

}
