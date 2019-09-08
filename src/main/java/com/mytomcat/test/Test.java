package com.mytomcat.test;

import com.mytomcat.MyTomcat;
//测试
public class Test {
  public static void main(String[] args) {
	MyTomcat myTomcat = new MyTomcat(8080);
	myTomcat.start();
}
}
