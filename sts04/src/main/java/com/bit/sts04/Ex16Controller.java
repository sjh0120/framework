package com.bit.sts04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex16Controller {

	@RequestMapping("/ex16")
	public String ex16() {
		return "ex01";
	}
	
	/*
	@RequestMapping("/logo.jpg")
	public void logo(HttpServletResponse res) throws IOException {
		
		ServletOutputStream os=res.getOutputStream();
		File file=new File("�����ּ�");
		InputStream is=new FileInputStream(file);
		while(true) {
			int su=is.read();
			if(su==-1)break;
			os.write(su);
		}
		is.close();
		os.close();
	}
	*/
}
