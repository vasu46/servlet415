package com.nt.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
@WebListener
public class RequestListener implements ServletRequestListener {
	
	private long start=0,end=0;
	
	   
	
	public RequestListener() {
		System.out.println("RequestListener.RequestListener()::O param Constructor");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestInitilized()");
		start=System.currentTimeMillis();
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestListener.requestDestroyed().requestDestroy()");
		end=System.currentTimeMillis();
		//get HttpServeltRequest ObJECT
		HttpServletRequest req=(HttpServletRequest) sre.getServletRequest();
		//get Servlet Context
		ServletContext sc=req.getServletContext();
		sc.log(req.getRequestURI()+" has Taken"+(end-start)+"ms time to process the request");
		System.out.println(req.getRequestURI()+" has Taken"+(end-start)+"ms time to process the request");
		  
		
	}

}
