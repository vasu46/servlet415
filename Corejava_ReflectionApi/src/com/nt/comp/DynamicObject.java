package com.nt.comp;

import java.lang.reflect.Constructor;

public class DynamicObject {

	public static void main(String[] args) {
		try {
			//load clss
			Class c=Class.forName(args[0]);
			//create dynamic obj
			/*
			  Object obj=c.newInstance(); 
			  System.out.println(obj);
			 }*/
			//get All constructors
			Constructor cons[]=c.getDeclaredConstructors();
			
			
			  //Object creation usin 0-param constructo
			  Object obj=cons[0].newInstance();
			  System.out.println("0param data::"+obj);
			  System.out.println("----------------------");
			 
			 
			//Object creation usin parameterconstrucor
			Object obj1=cons[1].newInstance(45,80);
			System.out.println("data of obj2::"+obj1);
		   System.out.println("-------------------");
		 
		   //cretae string param obj
		   
		   Object obj2=cons[2].newInstance("anajan","vikas",4);
		   System.out.println("string param data::"+obj2);
		   
		  
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
