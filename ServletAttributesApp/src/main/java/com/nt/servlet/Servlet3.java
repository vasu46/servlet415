package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//setContent type
	res.setContentType("text/html");
	//PrintWriter 
	PrintWriter pw=res.getWriter();
	//get REQ Attributews
		pw.println("<br><b>Servelt3::attr1(req)value::"+req.getAttribute("attr1")+"</b>");

		//get Session attributes
		HttpSession ses=req.getSession();
		pw.println("<br><b>Servelt3::username(req)value::"+ses.getAttribute("username")+"</b>");
		
		//read request attribute values
		ServletContext sc=getServletContext();
		pw.println("<br><b>Servelt3::email(req)value::"+sc.getAttribute("email")+"</b>");
	
	
}//doGet
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}

}
