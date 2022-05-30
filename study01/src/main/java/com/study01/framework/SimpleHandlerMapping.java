package com.study01.framework;

import java.util.HashMap;
import java.util.Map;

public class SimpleHandlerMapping {

	Map<String,TotalController> cmap=new HashMap<>();
	
	String path;
	
	public Map<String,TotalController> getMapping() {
		return cmap;
	}

	public void setPath(String path) {
		this.path = path;
		mapping();
	}

	private Map<String,TotalController> mapping() {
		Map<String,String> handler=new HashMap<>();
		handler.put("index", "com.study01.emp.controller.IndexController");
		handler.put("list", "com.study01.emp.controller.ListController");
		
		return cmap;
	}
}
