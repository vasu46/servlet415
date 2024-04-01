package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
   private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
   
   @Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get Printwriter
	   PrintWriter pw=res.getWriter();
	   //set Content type
	   res.setContentType("text/html");
	   
	   //set Context type
	     ServletContext sc=getServletContext();
	     pw.println("<h1 style='color:bule'>ServeltContext class Obj  hashcode::"+sc.hashCode());
	     
	     String driver=sc.getInitParameter("driverClass");
	     String url=sc.getInitParameter("url");
	     String userName=sc.getInitParameter("username");
	     String password=sc.getInitParameter("password");
	   
	   //set jdbc connection
		     int no=Integer.parseInt(req.getParameter("eno"));
		  
			   try {
				Class.forName(driver);
			   } 
			   catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
		
		   try(Connection con=DriverManager.getConnection(url,userName,password);
				   PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS);){
			   if(ps!=null)
				   //set value
				   ps.setInt(1, no);
			   try(ResultSet rs=ps.executeQuery()){
				   if(rs!=null) {
					   if(rs.next()) {
						   pw.println("<h1 style='color:red;text-align:center'>Employee Details are::</h1>");
						   pw.println("<h1 style='color:red;text-align:center'>Employee Number is::"+rs.getInt(1)+"</h1>");
						   pw.println("<h1 style='color:red;text-align:center'>Employee Name is::"+rs.getString(2)+"</h1>");
						   pw.println("<h1 style='color:red;text-align:center'>Employee job is::"+rs.getString(3)+"</h1>");
						   pw.println("<h1 style='color:red;text-align:center'>Employee sal is::"+rs.getFloat(4)+"</h1>");
						   pw.println("<h1 style='color:red;text-align:center'>Employee Number is::"+rs.getInt(5)+"</h1>");  
					   }
					   else {
						   pw.println("<h1 style='color:red;text-align:center'>Employee Details are not Found::</h1>");
				       }//else
					}//if	
				   pw.println("<h1 style='color:red;text-align:center'><a href='form.html'>Home</a></h1>");
				   pw.close();
				   
		   }//try1
			   
	   }//try2
		   catch(SQLException se) {
			   se.printStackTrace();
			   System.out.println("Error is Occured in Sql");
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   System.out.println("Error is occrured in unkonw::");
		   }
		   	   
	}//doGet
   
	  @Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req,res);
		}
}
