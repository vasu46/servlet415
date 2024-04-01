package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
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
	    	//set req attributes
	    	req.setAttribute("attr1","val1");
	    	//forward request Servelt2
	    	RequestDispatcher rd=req.getRequestDispatcher("/s2url");
	    	rd.forward(req, res);
	    
	    	
	    	
	    }//doGet
	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	doGet(req,res);
	    }
		

}
