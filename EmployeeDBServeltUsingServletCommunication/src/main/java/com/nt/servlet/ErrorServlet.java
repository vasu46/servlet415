package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ErrorServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get the PrintWrietr
		PrintWriter pw=res.getWriter();
		pw.println("<b><h1 style='color:red;text-align:center'>Internal Problem of the server Plz try ofter some time</h1></b>");
		pw.close();
		
		
	}

}
