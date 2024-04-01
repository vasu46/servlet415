package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<table border='1' bgcolor='cyan' align='center'>");
		pw.println("<tr><th>IPL TEAM</th><th>Caption</th><th>Management</th></tr>");
		pw.println("<tr><td>MI</td><td>Rohit Sharama</td><td>Reliance</td>");
		pw.println("<tr><td>CSK</td><td>DHONI</td><td>DECEN CEMENT</td>");
		pw.println("<tr><td>RCB</td><td>KOHILI</td><td>UBL</td>");
		pw.println("<tr><td>GT</td><td>HARDIK PANDY</td><td>CVC Capitals</td>");
		pw.println("<tr><td>SRH</td><td>WARNER</td><td>KAVYA</td>");
		pw.println("</table>");
		pw.close();
		
		
	}

}
