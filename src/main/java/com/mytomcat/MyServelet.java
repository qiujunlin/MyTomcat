package com.mytomcat;

//servlet 的父类  相当于 HttpServlet

public abstract class MyServelet {
	
	public void service(MyRequest myRequest, MyResponse myResponse) {
		if(myRequest.getMethod().equalsIgnoreCase("POST")) {
			doPost(myRequest, myResponse);
		}else if(myRequest.getMethod().equalsIgnoreCase("GET")) {
			doGet(myRequest, myResponse);
		}
	}
	
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		
	}
	
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		
	}
	
}
