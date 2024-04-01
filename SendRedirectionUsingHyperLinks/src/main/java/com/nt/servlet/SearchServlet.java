package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sed")
public class SearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
	//get searchParameter
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
	//get Href
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>Click");
		if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>Click");
		else
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.yahoo.com/search?p="+ss+"'>Click");
    
		//clise
		pw.close();
	}//doget
	
		//doPost
		public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			doGet(req,res);
}//post
}//class
