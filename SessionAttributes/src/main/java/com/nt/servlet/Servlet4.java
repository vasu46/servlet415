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

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//setContent type
    	res.setContentType("text/html");
    	//PrintWriter 
    	PrintWriter pw=res.getWriter();
    	//read request attributes
    	HttpSession ses=req.getSession();
    	pw.println("<br><b>Servel4::username(req)value::"+ses.getAttribute("username")+"</b>");
    	pw.println("<br><b>Servelt4::password(req)value::"+ses.getAttribute("password")+"</b>");
    	
    	
    }//doGet
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req,res);
    }
	
	
		
	}


