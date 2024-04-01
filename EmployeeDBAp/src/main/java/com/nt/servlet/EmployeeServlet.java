package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get pRINTwrietr
		PrintWriter pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read the dat from from.html
		int no=Integer.parseInt(req.getParameter("eno"));
		//write the JdBC cODE FRO DDb interaction
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//load jdbc driver calss
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			//cretae the Statement
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			//set the query param vlue
			ps.setInt(1, no);
			//procees th eresult
			rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("<h1 style='color:blue'>Employee No::"+rs.getInt(1)+"</h1>");
				pw.println("<h1 style='color:blue'>Employee Name::"+rs.getString(2)+"</h1>");
				pw.println("<h1 style='color:blue'>Employee job::"+rs.getString(3)+"</h1>");
				pw.println("<h1 style='color:blue'>Employee sal::"+rs.getFloat(4)+"</h1>");
				pw.println("<h1 style='color:blue'>Employee DeptNo::"+rs.getInt(5)+"</h1>");
			}
			else{
				pw.println("<h1 style='color:red'>Emploee Not Found</h1>");	
			}
			//home hyperlink
			pw.println("<a href='form.html'>Home</a>");
		}
			catch(SQLException se) {
				se.printStackTrace();
				pw.println("<h4 style='color:red'>DB Problem::"+se.getMessage()+"</h4>");	
			}
			catch(Exception e) {
				e.printStackTrace();
				pw.println("<4 style='color:red'>unknow Problem::"+e.getMessage()+"</h4>");	
			}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}//doGet
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//dopost

}
