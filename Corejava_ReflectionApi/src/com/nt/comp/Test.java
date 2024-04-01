package com.nt.comp;

public class Test {
	private int a=10,b=20,id=30;
	private String name="vasu",college="vikas";
	
	
	 
	  
	public Test() {
		
	  System.out.println("Test.Test():0-param constrictor:;"); 
   }
	public Test(int a,int b) {
		this.a=a;
		this.b=b;
		System.out.println("Test.Test()2-param constructor:;");
	}
	public Test(String name,String college,int id) { 
		this.name=name;
		this.college=college;
		this.id=id;
		} 
	@Override
	public String toString() {
		return "Test[a="+a+" b="+b+"name="+name+" college="+college+"id="+id+"]";
	}

}
