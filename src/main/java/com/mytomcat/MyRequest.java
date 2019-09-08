package com.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

//封装请求
public class MyRequest {
	
	private String url;
	private String method;
	
	public MyRequest(InputStream inputStream) throws IOException{
		String httpRequest = "";
		
		byte[] httpRequestBytes = new byte[1024];
		
		int length = 0;
		
		if((length = inputStream.read(httpRequestBytes)) > 0) {
			httpRequest = new String(httpRequestBytes, 0, length);
		}
		String top = httpRequest.split("\n")[0];
		String tops[] = top.split("\\s");
		System.out.println("请求行："+Arrays.toString(tops));
		method = tops[0];
		url = tops[1];
		System.out.println("请求头："+httpRequest);
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "MyRequest [url=" + url + ", method=" + method + "]";
	}
	
	
}
