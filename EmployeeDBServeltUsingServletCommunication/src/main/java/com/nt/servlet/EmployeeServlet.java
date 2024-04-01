package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	private static final String GET_EMPLOYEE_DETAILS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		try {
			 pw=res.getWriter();
		res.setContentType("text/html");
		//include the headre content
		RequestDispatcher rd=req.getRequestDispatcher("/headurl");
		  rd.include(req,res);
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driverClass");
		String url=sc.getInitParameter("url");
		String username=sc.getInitParameter("username");
		String password=sc.getInitParameter("password");
		
		int no=Integer.parseInt(req.getParameter("eno"));
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection(url,username,password);
				PreparedStatement ps=con.prepareStatement(GET_EMPLOYEE_DETAILS);){
			//set input values
			  if(ps!=null)
			   ps.setInt(1, no);
			
			//result set
			try(ResultSet rs=ps.executeQuery()){
				if(rs!=null) {
					if(rs.next()) {
						pw.println("<h1 style='color:blue;text-align:center'>Employee Details::</h1>");
						pw.println("<h1 style='color:green;text-align:cenetr'>EmployeeNo::"+rs.getInt(1)+"</h1>");
						pw.println("<h1 style='color:green;text-align:cenetr'>EmployeeName::"+rs.getString(2)+"</h1>");
						pw.println("<h1 style='color:green;text-align:cenetr'>Employee job::"+rs.getString(3)+"</h1>");
						pw.println("<h1 style='color:green;text-align:cenetr'>Employee sal::"+rs.getFloat(4)+"</h1>");
						pw.println("<h1 style='color:green;text-align:cenetr'>Employee deptno::"+rs.getInt(4)+"</h1>");
						
					}
					else {
						pw.println("<h1 style='color:green;text-align:cenetr'>Employee details are not found:;</h1>");
					}
					 pw.println("<br><br>");
					   pw.println("<b>server info::"+sc.getServerInfo()+"</b>");
					   pw.println("<b>servlet api version::"+sc.getMajorVersion()+"."+sc.getMinorVersion()+"</b>");
					   pw.println("<b>servelt MiME TYPE::"+sc.getMimeType("/form.html")+"</b>");
					   pw.println("<b>name of the web appliction"+sc.getContextPath()+"</b>");
					   pw.println("<b>virtuval server name::"+sc.getVirtualServerName()+"</b>");
					
				}//if
					   pw.println("<h1 style='color:blue'><a href='form.html'>home</a></h1>");
						
			}//try2
			
		}//try1
		
		//inlcude foter content
		RequestDispatcher rd1=req.getRequestDispatcher("/fotter.html");
		  rd1.include(req,res);
	    pw.close();
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
		
	}//doGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}

}
