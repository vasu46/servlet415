package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class DBTestServlet extends HttpServlet {
	static {
		System.out.println("DBTestServlet::static Block::");
	}
	
	public DBTestServlet(){
		System.out.println("DBTestServlet.DBTestServlet()::o param constructor::");
	   }
	
	    @Override
	    public void init(ServletConfig cg) throws ServletException {
	    	System.out.println("int config method is Excecuted::");
	    	System.out.println("driverClassName::"+cg.getInitParameter("diverClass"));
	    	System.out.println("driverUrl::"+cg.getInitParameter("url"));
	    	System.out.println("DbUserName::"+cg.getInitParameter("username"));
	    	System.out.println("DbPasswored::"+cg.getInitParameter("password"));
	    }
	    
	    
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("DBservlet  service method is EXECUTED:;");
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 pw.println("<h1 style='color:red;text-alig:center'>SystemDateAndTime is::"+new java.util.Date()+"</h1>");
		 pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method is executed::");
	}

}
