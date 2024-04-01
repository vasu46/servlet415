package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	//setContent type
	res.setContentType("text/html");
	//PrintWriter 
	PrintWriter pw=res.getWriter();
	//read request attribute values
	ServletContext sc=getServletContext();
	pw.println("<br><b>Servelt2::email(req)value::"+sc.getAttribute("email")+"</b>");
	
	//forward request Servelt2
	RequestDispatcher rd=req.getRequestDispatcher("/s3url");
	rd.forward(req, res);

	
	
}//doGet
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}
	

}
