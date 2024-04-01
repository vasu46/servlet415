package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//write form to servlet req scope
		String name=req.getParameter("pname");
		String page=req.getParameter("page");
		int age=Integer.parseInt(page);
		//writer the B.logic
		if(age>=18 && age<=100)
			pw.println("<h1 style='color:green;text-align:center'>Mr/Mrs"+name+" u r Eligible to Voting</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Mr/Mrs"+name+" u r not Eligible to Voting</h1>");
		
		pw.println("<h3 style='color:blue;text-align:right'><a href='http://localhost:2023/VoterApp/details_form.html'>Go to Home</a></h3>");
		pw.close();
			
	}

}
