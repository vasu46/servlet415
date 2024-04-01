package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//setContent type
	res.setContentType("text/html");
	//PrintWriter 
	PrintWriter pw=res.getWriter();
	
	//READ REUEST ATTRIBUTES VALUES
	ServletContext sc=getServletContext();
	pw.println("<br><b>Servelt3::email(req)value::"+sc.getAttribute("email")+"</b>");
	
	
	
}//doGet
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}

}
