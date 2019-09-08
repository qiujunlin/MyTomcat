package com.mytomcat;

import java.util.ArrayList;
import java.util.List;
//封装servlet配置信息
public class ServeletMappingConfig {
	public static List<ServeletMapping> serveletMappingList = new ArrayList<ServeletMapping>();
	
	 static {
        serveletMappingList.add(new ServeletMapping("Servlet1", "/Servlet1", "com.mytomcat.servlet.Servlet1"));
        serveletMappingList.add(new ServeletMapping("Servlet2", "/Servlet2", "com.mytomcat.servlet.Servlet2"));
	 }
	
}
