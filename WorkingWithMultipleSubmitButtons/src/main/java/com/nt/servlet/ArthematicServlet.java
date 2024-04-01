package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArthematicServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set PRINTwRITER
		PrintWriter pw=res.getWriter();
		//set Content tye
		res.setContentType("text/html");
        
        int fn=0;
        int sn=0;
        
        String sval=req.getParameter("s1");
           if(!sval.equalsIgnoreCase("link1") && !sval.equalsIgnoreCase("link2")) {
        	    fn=Integer.parseInt(req.getParameter("f1"));
        	    sn=Integer.parseInt(req.getParameter("se"));
           }
    	    	if(sval.equalsIgnoreCase("add")) {
    	    		pw.println("<b><h1 style='color:red;text-align:cenetr'>Adding Two numbers value is:: "+(fn+sn)+"</h1></b>");
    	    		
    	    	}
    	    	else if(sval.equalsIgnoreCase("sub")) {
    	    		pw.println("<b><h1 style='color:red;text-align:center'>substraction Two numbers value is:: "+(fn-sn)+"</h1></b>");
    	    		
    	    	}
    	    	else if(sval.equalsIgnoreCase("mul")) {
    	    		pw.println("<b><h1 style='color:red;text-align:center'>Multiflication Two numbers value is:: "+(fn*sn)+"</h1></b>");
    	    		
    	    	}
    	    	else if(sval.equalsIgnoreCase("div")) {
    	    		pw.println("<b><h1 style='color:red;text-align:center'>division of Two numbers value is:: "+(fn/sn)+"</h1></b>");
    	    		
    	    	}
    	    	else if(sval.equalsIgnoreCase("mod")) {
    	    		pw.println("<b><h1 style='color:red;text-align:center'>modulelo of Two numbers value is:: "+(fn/sn)+"</h1></b>");
    	    		
    	    	}
    	    	else if(sval.equalsIgnoreCase("link1")) {
    	    		pw.println("<b><h1 style='color:red;text-align:center'>System Properties is::"+System.getProperties()+"</h1></b>");
    	    		
    	    	}
    	    	else 
    	    		pw.println("<b><h1 style='color:red;text-align:center'>SystemDateTime::"+LocalDateTime.now()+"</h1></b>");
           
    	    
    	         //get home page
    	    	pw.println("<h1 style='color:red;text-align:center'><a href='form.html'>get HomePage</a><h1>");
    	    	pw.close();
    	    	
    	    	
    	    
  
    	
           }//doget
    @Override
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 doGet(req,res);
    }

}
