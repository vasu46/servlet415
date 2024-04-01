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
@WebServlet("/s1url")
public class Servlet1 extends HttpServlet{
	 @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	//setContent type
	    	res.setContentType("text/html");
	    	//PrintWriter 
	    	PrintWriter pw=res.getWriter();
	    	//set seesion Attributesattributes
	    	ServletContext sc=getServletContext();
	    	sc.setAttribute("email","vasuKothem108gmail.com");
	    	
	       RequestDispatcher rd=req.getRequestDispatcher("/s2url");
	    	rd.forward(req, res);
	    	
	    	
	    	
	    }//doGet
	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	doGet(req,res);
	    }
		

}
