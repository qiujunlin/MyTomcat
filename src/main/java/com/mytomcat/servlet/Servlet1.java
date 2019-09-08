package com.mytomcat.servlet;

import java.io.IOException;

import com.mytomcat.MyRequest;
import com.mytomcat.MyResponse;
import com.mytomcat.MyServelet;
//自定义servlet 继承 Myservlet
public class Servlet1 extends MyServelet {
	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
			myResponse.write(" Hellp this is Servlet1!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		super.doGet(myRequest, myResponse);
	}
	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		// TODO Auto-generated method stub
		super.doPost(myRequest, myResponse);
	}

}
