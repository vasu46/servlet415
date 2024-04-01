package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//Get Writer 
		PrintWriter pw=res.getWriter();
		//set Content type in
         res.setContentType("text/html");
         //geting form pages values
         String name=req.getParameter("pname");
         String tage=req.getParameter("page");
         int age=Integer.parseInt(tage);
         //write vote eleigibility logic
         if(age>=18)
        	 pw.println("<h1 style='color:green;text-align:center'>Mr/MRS/MISS "+name+" U R ELIGIBLE TO VOTING</h1>");
         else
        	 pw.println("<h1 style='color:red;text-align:center'>Mr/MRS/MISS "+name+" U R NOT ELIGIBLE TO VOTING</h1>");
       //get link in dETAILS_fORM PAG
       pw.println("<b><h1><a href='http://localhost:2028/VoterApp/details_form.html'><img src='D:\\Apache Software Foundation\\servlet_Images/home.png' width='100' height='200'>GetHomePage</a></h1></b>");
	
	//close pw
       pw.close();
	}
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//Get Writer 
 		PrintWriter pw=res.getWriter();
 		//set Content type in
          res.setContentType("text/html");
          pw.println("<h1 style='color:green;text-align:center'>SYSYEM DATE AND TIME IS::"+new Date()+"</h1>");
    }
}
