package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeReg extends HttpServlet {
	private static final String REG_EMP_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(SEQ1.NEXTVAL,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		try {
		 pw=res.getWriter();
		res.setContentType("text/html");
		
		
				  
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driverClass");
		String url=sc.getInitParameter("url");
		String username=sc.getInitParameter("username");
		String password=sc.getInitParameter("password");
		
		//get inputs
		 String name=req.getParameter("ename");
		 String job=req.getParameter("job");
		 Float sal=Float.parseFloat(req.getParameter("sal"));
		 int deptno=Integer.parseInt(req.getParameter("deptno"));
		 
		 try {
			 Class.forName(driver);
			 
		 }
		 catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		 }
		 try(Connection con=DriverManager.getConnection(url,username,password);
				 PreparedStatement ps=con.prepareStatement(REG_EMP_DETAILS);){
			 //set input vlaues
			 if(ps!=null) {
                ps.setString(1,name);
                ps.setString(2,job);
                ps.setFloat(3,sal);
                ps.setInt(4,deptno);
			 
			 //execute the quer
			   int count=ps.executeUpdate();
			   if(count<0)
				   pw.println("<h1 style='color:red;text-align:center'> Employee is not Registered::</h1>");
				   else
					   pw.println("<h1 style='color:red;text-align:center'> Employee is Registered::"+count+"</h1>");
			   
			 }//if  
			   pw.println("<h1 style='color:blue'><a href='form1.html'>getRegPage</a></h1>");
			 }//try
		 
		
		}//try	
		 catch(Exception e) {
			 e.printStackTrace();
				
				pw.println("<b>befire rd.forward(-,-)</b>");
				System.out.println("MainServlet:: before rd.forward(req,res");
				
				 RequestDispatcher rd3=req.getRequestDispatcher("errurl");
				 rd3.forward(req,res);
				 
				 pw.println("<b>befire rd.forward(-,-)</b>");
					System.out.println("MainServlet:: before rd.forward(req,res");
			}
		 
		
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}
}
