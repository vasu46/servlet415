package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentDataAnalyzerServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get Wruetr
		PrintWriter pw=res.getWriter();
   //set Content Type
		res.setContentType("text/html");
   //read form data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String qlfy=req.getParameter("qlfy");
		long contactNo=Long.parseLong(req.getParameter("contactNo"));
		String[] hobies=req.getParameterValues("hb");
		if(hobies==null)
			hobies=new String[] {"no hobies are selected"};
		String favColors[]=req.getParameterValues("favColors");
		if(favColors==null)
			 favColors=new String[] {"No FavColors are Selected"};
		String ms=req.getParameter("ms");
		 if(ms==null)
			 ms="single";
		 
		 String dob=req.getParameter("dob");
		 String tob=req.getParameter("tob");
		 String mob=req.getParameter("mob");
		 String wob=req.getParameter("wob");
		 String nickName=req.getParameter("petname");
		 String scolor=req.getParameter("scolor");
		 long salary=Long.parseLong(req.getParameter("salrange"));
		 String ss=req.getParameter("ss");
		 int favNo=Integer.parseInt(req.getParameter("favNo"));
		 String fburl=req.getParameter("fburl");
		 
		 //calculate age
		  java.util.Date udob=java.sql.Date.valueOf(dob);
		  
		  java.util.Date sysDate=new java.util.Date();
		  
		  double age=(sysDate.getTime()-udob.getTime())/(1000.0*60.0*24.0*365.25);
		  //wite analyzer of data
		  if(gender.equalsIgnoreCase("M")) {
			  if(age<5)
				  pw.println("<h1>Master."+name+" u r baby biy</h1>");
			  
			  else if(age<13)
				  pw.println("<h1>Master."+name+" u r Samll Boy</h1>");
			  else if(age<20)
				  pw.println("<h1>Master."+name+" u r Tennager boy</h1>");
			  else if(age<35)
				  pw.println("<h1>Master."+name+" u r young boy</h1>");
			  else if(age<50)
				  pw.println("<h1>Master."+name+" u r middleage</h1>");
			  else
				  pw.println("<h1>Master."+name+" u r old man</h1>");
		  }//if
		  else {
			  if(age<5)
				  pw.println("<h1>Master."+name+" u r baby girl</h1>");
			  
			  else if(age<13)
				  pw.println("<h1>Master."+name+" u r Samll girl</h1>");
			  
			  else if(age<20) {
				   if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1>Mrs."+name+" u r Tennager girl</h1>");
			  
			       else
				      pw.println("<h1>Miss."+name+" u r Tennager girl</h1>");
			  }
		  else if(age<35) {
			   if(ms.equalsIgnoreCase("married"))
			     pw.println("<h1>Mrs."+name+" u r young woman</h1>");
		     else
			  pw.println("<h1>Miss."+name+" u r young woman</h1>");
	  }
		  else if(age<50) {
			   if(ms.equalsIgnoreCase("married"))
			     pw.println("<h1>Mrs."+name+" u r Middle age woman</h1>");
		     else
			  pw.println("<h1>Miss."+name+" u r Middle age woman</h1>");
	      }
			  else {
				  if(ms.equalsIgnoreCase("married"))
					     pw.println("<h1>Mrs."+name+" u r Old age woman</h1>");
				     else
					  pw.println("<h1>Miss."+name+" u r old age woman</h1>");
			      }
		  }
		 //display the recived from date
	  pw.println("<h1 style='color:blue'>The form data is:::</h1>");
	  pw.println("<br><b>name::"+name+"</b>");
	  pw.println("<br><b>address::"+addrs+"</b>");
	  pw.println("<br><b>gender::"+gender+"</b>");
	  pw.println("<br><b>ContactNo::"+contactNo+"</b>");
	  pw.println("<br><b>maritalStatus::"+ms+"</b>");
	  pw.println("<br><b>email::"+email+"</b>");
	  pw.println("<br><b>DOB::"+dob+"</b>");
	  pw.println("<br><b>TOB::"+tob+"</b>");
	  pw.println("<br><b>MOB::"+mob+"</b>");
	  pw.println("<br><b>WOB::"+wob+"</b>");
	  pw.println("<br><b>qualification::"+qlfy+"</b>");
	  pw.println("<br><b>favColors::"+favColors+"</b>");
	  pw.println("<br><b>hobies::"+hobies+"</b>");
	  pw.println("<br><b>nickname::"+nickName+"</b>");
	  pw.println("<br><b>FavoriteNumber::"+favNo+"</b>");
	  pw.println("<br><b>SentimentColor::"+scolor+"</b>");
	  
	  pw.println("<br><b>ExceptedSALARY::"+salary+"</b>");
	  
	  pw.println("<br><b>Fb Url::"+fburl+"</b>");
	  
	  pw.println("<br><b>GoogleSearch::"+ss+"</b>");
	  
	  //add home page
	   pw.println("<br><br><a href='student_registration.html'>home</a>");
	  
	//close the stream	 
	pw.close();	 
			
	}//do get
	  @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//dopost

}//class
