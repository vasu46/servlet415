package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//cretae the Cookies
		Cookie ck1=new Cookie("AP","AMARAVATHI");
		Cookie ck2=new Cookie("TS","HYDHARABAD");

		res.addCookie(ck1);
		res.addCookie(ck2);
		
		
		Cookie ck3=new Cookie("MH","MUMBAI");
		Cookie ck4=new Cookie("TA","CHHINNI");
		ck3.setMaxAge(1*60);
		ck4.setMaxAge(2*60);
		
		res.addCookie(ck3);res.addCookie(ck4);
		
		//get Writer
		PrintWriter pw=res.getWriter();
		
		//set response
		res.setContentType("text/html");
		
		pw.println("<br><b><h1 style='color:red;text-align:center'>Cookies are  created,added to Response and stored at client side </h1></b>");
		
		//close 
		pw.close();
		
	}//doGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
