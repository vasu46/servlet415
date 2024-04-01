package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/secondurl")
public class Servlet2 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//setPrint Writer
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//from2 values
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		
		//get access to the Session obj
		HttpSession ses=req.getSession();
		//read form1/req1 data asseesion attribute values 
		String name=(String) ses.getAttribute("name");
		String fname= (String) ses.getAttribute("fname");
		String ms=(String) ses.getAttribute("ms");
		
		//dispaly dynamic web page
		//having form1/req1 and form2/req2 data
		pw.println("<h1 style='color:red;text-align:center'>Person Information --shadi.com</h1>");
		pw.println("<h1 style=color:red;text-align:center'>form1 data:: name::"+name+" "+"fatherName::"+fname+" "+"MaritalStustus::"+ms+"</h1>");
		pw.println("<h1 style=color:red;text-align:center'>form2 data:: f2val1::"+f2val1+"... "+"f2val2::"+f2val2+"</h1>");
		
		//add home hyperlInk
		pw.println("<br><a href='details.html'>home</a>");
		pw.println("<br><b>Session id::"+ses.getId()+"</b>");
	}//doGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}		
}


