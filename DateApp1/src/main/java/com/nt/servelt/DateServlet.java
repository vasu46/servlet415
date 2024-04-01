package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DateServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		//get toDtae Dtae
		Date dt=new Date();
		//print response obj
		pw.println("<h1 style='color:red;text-align:center'>Date and Time is::"+dt+"</h1>");
		//get The hashcode for our servletobj,an req,res from Object class
		  pw.println("<br><b><h1 style='color:red;text-align:center'>Request Obj hashcode::"+req.hashCode()+"</h1></b>");
		  pw.println("<br><b><h1 style='color:red;text-align:center'>Response Obj hashcode::"+res.hashCode()+"</h1></b>");
		  pw.println("<br><b><h1 style='color:red;text-align:center'>ServletComp Obj hashcode::"+this.hashCode()+"</h1></b>");
		  pw.println("<br><b><h1 style='color:red;text-align:center'>Current Thread Request Obj hashcode::"+Thread.currentThread().hashCode()+"</h1></b>");
		
		  
		  
		pw.close();
	}
}
