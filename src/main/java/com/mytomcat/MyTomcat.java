package com.mytomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;


public class MyTomcat {
	private Integer port = 8080;
	
	private Map<String, String> urlServletMapping = new HashMap<String, String>();

	public MyTomcat(Integer port) {
		super();
		this.port = port;
	}
	
	public void start() {
		initServletMapping();
		
		while(true) {
			ServerSocket serverSocket = null;     //ʵ����һ�� ServerSocket ���󣬱�ʾͨ���������ϵĶ˿�ͨ��
			try {
				serverSocket = new ServerSocket(port);   
				System.out.println("MyTomcat is starting...");
				while(true) {
					Socket socket = serverSocket.accept();     //���������� ServerSocket ��� accept() �������÷�����һֱ�ȴ���ֱ���ͻ������ӵ��������ϸ����Ķ˿� 
					InputStream inputStream = socket.getInputStream();
					OutputStream outputStream = socket.getOutputStream();
					
					MyRequest myRequest = new MyRequest(inputStream);
					MyResponse myResponse = new MyResponse(outputStream);
					
					dispatch(myRequest, myResponse);
					socket.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
//		}finally {
//			if(serverSocket != null) {
//				try {
//					serverSocket.close();
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
	public void initServletMapping() {
		for(ServeletMapping servletMapping : ServeletMappingConfig.serveletMappingList) {
			urlServletMapping.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void dispatch(MyRequest myRequest, MyResponse myResponse) {
		String clazz = urlServletMapping.get(myRequest.getUrl());
		
		try {
			Class<MyServelet> myServletClass = (Class<MyServelet>)Class.forName(clazz); 
			MyServelet myServelet = myServletClass.newInstance();
			myServelet.service(myRequest, myResponse);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        MyTomcat myTomcat = new MyTomcat(8080);
        myTomcat.start();
    }
	
}
