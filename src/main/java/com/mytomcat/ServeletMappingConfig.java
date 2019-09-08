package com.mytomcat;

import java.util.ArrayList;
import java.util.List;

public class ServeletMappingConfig {
	public static List<ServeletMapping> serveletMappingList = new ArrayList<ServeletMapping>();
	
	 static {
        serveletMappingList.add(new ServeletMapping("index", "/index", "myTomcat.test.IndexServlet"));
        serveletMappingList.add(new ServeletMapping("myblog", "/myblog", "myTomcat.test.MyBlog"));
	 }
	
}
