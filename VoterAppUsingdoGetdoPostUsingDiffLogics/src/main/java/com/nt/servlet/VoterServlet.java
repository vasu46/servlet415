package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
   @Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   System.out.println("EXECUTING DO GET MERTHOD ::");
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String name=req.getParameter("pname");
	String tage=req.getParameter("page");
	int age=Integer.parseInt(tage);
	if(age>18 && age<120)
		pw.println("<b><h1 style='color:red;text-align:center'>Mr/Mrs/Miss."+name+"u r eligible for voting</h1></b>");
      
   else
	   pw.println("<b><h1 style='color:red;text-align:center'>Mr/Mrs/Miss."+name+"u r not eligible for voting</h1></b>");
	
        doGet(req,res);
	pw.println("<b><h1 style='color:yelloe;text-align:left'><a href='details_form.html'>getHomePage</a></h1></b>");
	 pw.close();
    }//do Post
   @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   System.out.println("EXECVUTING DO Post METHOD ");
	   PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1 style='color:green;text-align:center'>SYSTEMDATETIME IS::"+new Date()+"<h1>");
		pw.println("<b><h1 style='color:yelloe;text-align:left'><a href='details_form.html'>getHomePage</a></h1></b>");
		pw.close();
		
	}
}