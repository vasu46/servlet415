package com.nt.listeners;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class HttpListeners implements HttpSessionListener {
   private long start=0,end=0;

public HttpListeners() {
	System.out.println("HttpListeners.HttpListeners()::0 param Constructor");
}

@Override
public void sessionCreated(HttpSessionEvent se) {
	System.out.println("HttpListeners.sessionCreated().sessionCreated::");
	start=System.currentTimeMillis();
	//get Access to ServeltContext
	ServletContext sc=se.getSession().getServletContext();
	sc.log("session startted at::"+new Date());
	System.out.println("session start at::"+new Date());
}

@Override
public void sessionDestroyed(HttpSessionEvent se) {
	end=System.currentTimeMillis();
	System.out.println("Session ended at::"+new Date());
	//get Access to ServeltContext
	ServletContext sc=se.getSession().getServletContext();
	sc.log("Session ended at::"+new Date());
	System.out.println("Session duration::"+(end-start)+"ms");
	sc.log("Session duration::"+(end-start)+"ms");
    }
   
}
