package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class EmployeeServlet extends HttpServlet {
	private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get Writer
		PrintWriter pw=res.getWriter();
		//get response type
		res.setContentType("text/html");
		
		//get Servlet Config
		ServletConfig cg=getServletConfig();
		String driverClass=cg.getInitParameter("driverClass");
		String url=cg.getInitParameter("url");
		String userName=cg.getInitParameter("username");
		String password=cg.getInitParameter("password");
		
		//input valued read from form page
		int no=Integer.parseInt(req.getParameter("eno"));
		
		try {
		   Class.forName(driverClass);
		}
		catch(ClassNotFoundException cce) {
			cce.printStackTrace();	
		}
		try(Connection con=DriverManager.getConnection(url,userName,password);
				PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS);){
			if(ps!=null)
				//set input values
				ps.setInt(1, no);
			try(ResultSet rs=ps.executeQuery()){
				if(rs!=null) {
					if(rs.next()) {
						pw.println("<h1 style='color:red;text-align:cenetr'>Employee Details are</h1>");
						pw.println("<h1 style='color:red;text-align:center'>Employee Number::"+rs.getInt(1)+"</h1>");
						pw.println("<h1 style='color:red;text-align:center'>Employee Name::"+rs.getString(2)+"</h1>");
						pw.println("<h1 style='color:red;text-align:center'>Employee job::"+rs.getString(3)+"</h1>");
						pw.println("<h1 style='color:red;text-align:center'>Employee sal::"+rs.getFloat(4)+"</h1>");
						pw.println("<h1 style='color:red;text-align:center'>Employee Deptno::"+rs.getInt(5)+"</h1>");	
					}//if
			
				else {
					pw.println("<h1 style='color:red'>Employee is not Found::</h1>");
				}//else
				
			}//if
				pw.println("<br><b><h3 style='color:blue'>ServektConfig obj calss name::"+cg.getClass()+"</h3></b>");
				pw.println("<br><b><h2 style='color:blue'>ServeltConfing class name::"+cg.getServletName()+"</h2></b>");
				pw.println("<br><br><h2 style='text-align:center'><a href='form.html'>home</a></b>");
				
		
			ps.close();
		}	
		}
			  
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Exception in sql");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unknow execption");
		}
	  }//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	}//class



