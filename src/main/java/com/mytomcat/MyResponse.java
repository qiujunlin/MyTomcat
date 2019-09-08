package com.mytomcat;

import java.io.IOException;
import java.io.OutputStream;
//封装响应
public class MyResponse {
	private OutputStream outputStream;
	
	public MyResponse(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public void write(String content) throws IOException{
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/1.1 200 OK\n")
					.append("Content-Type:text/html\n")
					.append("\r\n")
					.append("<html><head><link rel=\"icon\" href=\"data:;base64,=\"></head><body>")//让网站不去请求图标  不然 会发起两次请求
					.append(content)
					.append("</body></html>");
		outputStream.write(httpResponse.toString().getBytes());
		outputStream.close();
	}
	
}
