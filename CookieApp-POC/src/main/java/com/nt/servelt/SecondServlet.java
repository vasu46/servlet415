package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //set content type
		res.setContentType("text/html");
		//get print Writer
		PrintWriter pw=res.getWriter();
		//read and dispaly the the Cookies
	   Cookie cookies[]=req.getCookies();
	   pw.println("<table border='1' bgcolor='cyan' align='center'>");
	   for(Cookie ck:cookies) {
		   pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td><tr>");
		   
	   }
	   pw.println("</table>");
	   //close 
	   pw.close();
	   
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
