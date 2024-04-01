package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	//get doGetMethdo
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get printWretr
		 PrintWriter pw=res.getWriter();
		 //set content type
		 res.setContentType("text/html");
		 String pval=req.getParameter("p1");
		Locale locales[]=Locale.getAvailableLocales();
		  if(pval.equalsIgnoreCase("link1")) {
			  pw.println("All Languages::");
			  for(Locale l:locales)
				   pw.println("<h3 style='color:red'>"+l.getDisplayLanguage()+"</h3>");
		  }
			  else if(pval.equalsIgnoreCase("link2")) {
				pw.println("Print ALl Countries");
				for(Locale l:locales)
					pw.println("<h3 style='color:red'>"+l.getDisplayCountry()+"</h3>");
			  }
			  else {
				  pw.println("<h1 style='color:red'>System date ansd time::"+LocalDateTime.now()+"</h1>");  
			  }
		  //get Home page
		    pw.println("<h1 style='color:red'><b><a href='links.html'>get homePage</a><b></h1>");
		    //close stream
		    pw.close();
		  }//doget
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
	 }
	}


