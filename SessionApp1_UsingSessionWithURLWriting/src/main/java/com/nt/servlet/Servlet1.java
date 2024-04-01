package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/firsturl")
public class Servlet1 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set PrintWriter
		PrintWriter pw=res.getWriter();
		//setContext type
		res.setContentType("text/html");
		//get form data
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String ms=req.getParameter("ms");
		
		//cretae Session Obj
		HttpSession ses=req.getSession();
	      ses.setAttribute("name",name);
	      ses.setAttribute("fname",fname);
	      ses.setAttribute("ms",ms);
	      
	      ses.setMaxInactiveInterval(60);
	      
	      //generate dynamic form page basesd on the marital Object
	      if(ms.equalsIgnoreCase("single")) {
	    	  pw.println("<h1 style='color:green;text-align:text'>Person Registration ....shadi.com");
	    	  pw.println("<form action="+res.encodeURL("secondurl")+" method='post'>");
	    	  pw.println("<table border='0' bgcolor='cyan' align='center'>");
	    	  pw.println("<tr><td>why do u want marry?</td>");
	    	  pw.println("<td><input type='text' name='f2t1'></td></tr>");
	    	  pw.println("<tr><td>When do u want marry?</td>");
	    	  pw.println("<td><input type='text' name='f2t2'></td></tr>");
	    	  pw.println("<tr><td colspan='2' align='center'><input type='submit' value='submit'>");
	    	  pw.println("</table>");
	    	  pw.println("</form>");  
	      }
	      else {
	    	  pw.println("<h1 style='color:green;text-align:text'>Person Registration(Married Life) ....shadi.com");
	    	  pw.println("<form action="+res.encodeURL("secondurl")+"method='post'>");
	    	  pw.println("<table border='0' bgcolor='cyan' align='center'>");
	    	  pw.println("<tr><td>Spouae name</td>");
	    	  pw.println("<td><input type='text' name='f2t1'></td></tr>");
	    	  pw.println("<tr><td>No of Childeren</td>");
	    	  pw.println("<td><input type='text' name='f2t2'></td></tr>");
	    	  pw.println("<tr><td colspan='2' align='center'><input type='text' value='submit'>");
	    	  pw.println("</table>");
	    	  pw.println("</form>");  
	      }//else
	     pw.println("<br><b>Session id::"+ses.getId());
	     pw.close();
	}//doGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
