package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{
	private static final String INSERT_STUDENT_VALUES="INSERT INTO STUDENT VALUES(SEQ1.NEXTVAL,?,?,?)";
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Wrietr 
		PrintWriter pw=res.getWriter();
		//get Input from html
		String name=req.getParameter("sname");
		String addrs=req.getParameter("saddrs");
		Float avg=Float.parseFloat(req.getParameter("avg"));
		
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
			ps=con.prepareStatement(INSERT_STUDENT_VALUES);
			//set Input values
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, avg);
			
			//execute the query
			int count=ps.executeUpdate();
			if(count<0) {
				pw.println("<h1 style='color:red;text-align:center'>Student is not Registered::</h1>");
				
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>Student is Registered is Sucessfull::"+count+"</h1>");
				
			}
			
			pw.close();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>SQLEXCEPTION"+se.getMessage()+"</h1>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unkonow execption"+e.getMessage()+"</h1>");
		}
		finally {
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
			
			}//finally
		}//doget
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	   }
	}//class
		


