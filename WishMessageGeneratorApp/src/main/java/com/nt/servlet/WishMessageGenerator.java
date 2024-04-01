package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageGenerator extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//b.logic
		//get Current Hour 
		LocalDateTime ldt=LocalDateTime.now();
		//get Current Hour
		int hour=ldt.getHour();
		if(hour<12)
			pw.println("<h1 style='color:red;text-align:center'>The Wish Message is::Gud Morning</h1>");
		else if(hour>12 && hour<16)
			pw.println("<h1 style='color:red;text-align:center'>The Wish Message is::Gud OfterNoon</h1>");
		else if(hour>16 && hour<=8)
			pw.println("<h1 style='color:red;text-align:center'>The Wish Message is::Gud Evening</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>The Wish Message is::Gud Night</h1>");
		
		pw.println("<a href='http://localhost:2023/WishMessageGeneratorApp/page.html'>Go to Home</a>");
		
		pw.close();
			
			
			
		
	}

	
}
