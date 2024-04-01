package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/xml");
		pw.println("<table border='1' bgcolor='cyan' align='center'>");
		pw.println("<tr><th>IPL TEAM</th><th>Caption</th><th>Management</th></tr>");
		pw.println("<tr><td>MI</td><td>Rohit Sharama</td><td>Reliance</td></tr>");
		pw.println("<tr><td>CSK</td><td>DHONI</td><td>DECEN CEMENT</td></tr>");
		pw.println("<tr><td>RCB</td><td>KOHILI</td><td>UBL</td></tr>");
		pw.println("<tr><td>GT</td><td>HARDIK PANDY</td><td>CVC Capitals</td></tr>");
		pw.println("<tr><td>SRH</td><td>WARNER</td><td>KAVYA</td></tr>");
		pw.println("</table>");
		pw.close();
		
		
	}

}
