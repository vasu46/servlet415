package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
         
         //server side Form validatio
         List<String> errorList=new ArrayList();
          if(name==null || name.equals("")||name.length()==0)
        	  errorList.add("Person name must be required");
          else if(name.length()<5 && name.length()>10)
        	  errorList.add("Person name must be Abov 5 ChARS and lessthan 10");
          else if(name.contains("@")==false)
        	   errorList.add("PersonName must be contain @ Symbol");
           
         float age=0.0f;
            if(tage==null ||tage.equals("")||tage.length()==0)
            	errorList.add("person age must be eneterrd ::");
            else {
            	try {
            		age=Float.parseFloat(tage);
            		if(age<0 || age>100) {
            			errorList.add("person age must be 0 to 100");
            		}
            	}
            	catch(NumberFormatException nfe) {
            		errorList.add("person age must be Numeric value");
            	}
            }
            //dispaly from validation error messaage
            if(errorList.size()>0)
            {
             for(String msg:errorList) {
            	 pw.println("<li style='color:red'><b>"+msg+"</li></b>");
             }//for
              return;	
            }//if
        
         //write vote eleigibility logic
         if(age>=18)
        	 pw.println("<h1 style='color:green;text-align:center'>Mr/MRS/MISS "+name+" U R ELIGIBLE TO VOTING</h1>");
         else
        	 pw.println("<h1 style='color:red;text-align:center'>Mr/MRS/MISS "+name+" U R NOT ELIGIBLE TO VOTING</h1>");
         
         pw.println("<br><b><h4 style='color:blue'>ServletRequestClassNAME::"+req.getClass()+"<h4></b>");
         pw.println("<br><b><h4 style='color:blue'>ServletResponseClassNAME::"+res.getClass()+"<h4></b>");
         
      
         //get link in dETAILS_fORM PAG
       pw.println("<b><h3><a href='details_form.html'><img src='D:\\Apache Software Foundation\\servlet_Images/home.png' width='100' height='200'>GetHomePage</a></h3></b>");
	
	//close pw
       pw.close();
	}
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("do get Method is execited");
    	doPost(req,res);
    }
}
