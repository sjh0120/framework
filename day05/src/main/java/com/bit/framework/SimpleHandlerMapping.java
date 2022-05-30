package com.bit.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SimpleHandlerMapping implements BitHandlerMapping {
	Map<String,BitController> cmap=new HashMap<>();
	
	String path;
	
	public Map<String,BitController> getMapping(){
		return cmap;
	}
	
	public void setPath(String path) {
		this.path = path;
		mapping();
	}
	
	public Map<String,BitController> mapping() {
//		try {
//			InitialContext initial=new InitialContext();
//			System.out.println(initial.getEnvironment());
//		} catch (NamingException e2) {
//			e2.printStackTrace();
//		}
		Map<String,String> handler=new HashMap<>();
		File file=new File(path);
		
		Properties prop=new Properties();
		InputStream is=null;
		try {
			is=new FileInputStream(file);
			prop.load(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Enumeration<Object>eles=prop.keys();
		while(eles.hasMoreElements()) {
			String key=(String) eles.nextElement();
			//System.out.println(key);
			handler.put(key,prop.getProperty(key));
		}
		
		Set<String> keys=handler.keySet();
		
		try {
			for(String key:keys)
			cmap.put(key, (BitController)(Class.forName(handler.get(key)).newInstance()));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cmap;
	}
}
