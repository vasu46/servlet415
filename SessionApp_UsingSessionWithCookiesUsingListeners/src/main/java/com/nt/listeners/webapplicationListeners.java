package com.nt.listeners;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class webapplicationListeners implements ServletContextListener {
  private long start=0,end=0;
   
public webapplicationListeners() {
	System.out.println("0-param Constructor::");
}


@Override
public void contextInitialized(ServletContextEvent sce) {
	System.out.println("WebAppMonitorListener.contextInitialized()");
	start=System.currentTimeMillis();
	//get ServeltConetxt Object
	ServletContext sc=sce.getServletContext();
	sc.log("WebApplication is deployed/reloaded/redeployed:"+new Date());;
	System.out.println("WebApplication is deployed reloaded redeployed:"+new Date());
   }

@Override
public void contextDestroyed(ServletContextEvent sce) {
	System.out.println("WebApplicationMonitor.contextDestroy() ");
	end=System.currentTimeMillis();
	ServletContext sc=sce.getServletContext();
	sc.log("WebApplication is undloyed/stopped at::"+new Date());
	System.out.println("Web Application is undeployed/stopped at::"+new Date());
}
}
  
  

