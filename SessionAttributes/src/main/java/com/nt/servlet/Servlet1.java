package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/s1url")
public class Servlet1 extends HttpServlet{
	 @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	//setContent type
	    	res.setContentType("text/html");
	    	//PrintWriter 
	    	PrintWriter pw=res.getWriter();
	    	//set seesion Attributesattributes
	    	HttpSession ses=req.getSession();
	    	ses.setAttribute("username","raja");
	    	ses.setAttribute("password","7825");
	       RequestDispatcher rd=req.getRequestDispatcher("/s2url");
	    	rd.forward(req, res);
	    	
	    	
	    	
	    }//doGet
	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	doGet(req,res);
	    }
		

}
