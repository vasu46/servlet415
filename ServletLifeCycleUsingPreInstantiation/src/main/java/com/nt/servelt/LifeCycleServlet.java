package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LifeCycleServlet extends HttpServlet{
	static {
		System.out.println("Static block is executed::");
	}
   public LifeCycleServlet() {
	   System.out.println("0-param Constructor::");
      }
    public void init(ServletConfig cg)throws ServletException{
    	System.out.println("ServletConfig is executed:;");
    
    }
    public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
    	 
    	   System.out.println("Servelt Service sMethod::");
    	   
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	pw.println("<h1 style='color:red;text-align:cenetr'> Date and Time::"+new java.util.Date()+"</h1>");
    	pw.close();
    }//service
    
    @Override
    public void destroy() {
    	System.out.println("LcTestServlet:;destroy()");
    }
   
	

}
