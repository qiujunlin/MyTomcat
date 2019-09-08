package com.mytomcat.servlet;

import java.io.IOException;

import com.mytomcat.MyRequest;
import com.mytomcat.MyResponse;
import com.mytomcat.MyServelet;

public class Servlet2 extends MyServelet{
	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {

		
		super.doGet(myRequest, myResponse);
	}
	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		// TODO Auto-generated method stub
		try {
			myResponse.write("Hellp this is servlet2!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
