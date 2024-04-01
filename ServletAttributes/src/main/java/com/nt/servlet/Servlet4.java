package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//setContent type
    	res.setContentType("text/html");
    	//PrintWriter 
    	PrintWriter pw=res.getWriter();
    	//read request attributes
    	pw.println("<br><br>Sertvelt4::attr1(req)::value::"+req.getAttribute("attr1")+"</b>");
    
    	
    	
    }//doGet
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req,res);
    }
	
	
		
	}


