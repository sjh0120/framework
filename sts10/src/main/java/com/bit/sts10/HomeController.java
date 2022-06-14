package com.bit.sts10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	String upPath="C:/Users/BIT/framework/sts10/src/upload/";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
		String filename=System.currentTimeMillis()+"_"+file.getOriginalFilename();
		System.out.println(filename);
		file.transferTo(new File(upPath+filename));
		req.setAttribute("origin", file.getOriginalFilename());
		req.setAttribute("filename", filename);
		return "down";
	}
	
	//<a href="down?file=${filename }">
	/*
	 * @RequestMapping(value="/down", method=RequestMethod.GET)
	public void down1(HttpServletResponse res,@RequestParam("file") String filename, @RequestParam("origin") String origin) {
		
		
		//规过 1
		
		File file=new File(upPath+filename);
		
		res.setContentType("application/octet-stream");
		
		res.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		try(
			OutputStream os=res.getOutputStream();
			InputStream is=new FileInputStream(file);
		){
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	/*
	//规过 2
	@RequestMapping(value="/down/{filename:.+}", method=RequestMethod.GET)
	public void down1(HttpServletResponse res,@PathVariable String filename) {
		System.out.println(filename);
	}
	*/
	@RequestMapping(value="/down/{filename:.+}", method=RequestMethod.GET)
	public void down2(HttpServletResponse res,@PathVariable String filename) {
		res.setContentType("application/octet-stream");
		
		res.setHeader("Content-Disposition","attachment; filename=\""+filename.substring(filename.indexOf('_')+1)+"\"");
		try(
				InputStream is=new FileInputStream(upPath+filename);
				OutputStream os=res.getOutputStream();
			){
			int su=-1;
			while((su=is.read())!=-1) {
				os.write(su);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
