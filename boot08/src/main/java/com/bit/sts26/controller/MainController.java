package com.bit.sts26.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	String apiPath="http://localhost:8070/api/emp";
	
	@GetMapping("/list")
	public ResponseEntity<String> list() throws URISyntaxException{
		URI url=new URI(apiPath);
		
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<String> entity=template.exchange(url, HttpMethod.GET, null, String.class);
		return entity;
	}
	
	@GetMapping("/list/{num}")
	public ResponseEntity<?> One(@PathVariable int num) throws URISyntaxException{
		URI url=new URI(apiPath+"/"+num);
		
		RestTemplate template=new RestTemplate();
		
		//내가 지정한 타입으로 contextType 설정 => text/html
//		String result = template.getForObject(url, String.class);
//		return ResponseEntity.ok(result);
		
		//JSON 타입으로 contextType 설정
//		ResponseEntity<String> result = template.getForEntity(url, String.class);
//		return result;
		
		//JSON 타입으로 contextType 설정00
		ResponseEntity<String> result = template.exchange(url, HttpMethod.GET, null, String.class);
		return result;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add() throws URISyntaxException{
		URI url=new URI(apiPath);
		
		RestTemplate template=new RestTemplate();
//		LinkedMultiValueMap<String, Object> req=new LinkedMultiValueMap<>();
//		req.add("ename","rest1");
//		req.add("pay",1234);
		
		HashMap<String,Object> params=new HashMap<>();
		params.put("ename","rest4");
		params.put("pay",4444);
		
//		LinkedMultiValueMap<String, String> header=new LinkedMultiValueMap<>();
//		header.add("Content-Type", "application/json");
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
//		HttpEntity entity=new HttpEntity<>(new Emp(0,1000,"test",null),headers);
//		HttpEntity entity=new HttpEntity<>(params);
		Map result=template.postForObject(url, params, Map.class);
		System.out.println(result);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> update() throws URISyntaxException{
		URI url=new URI(apiPath+"/"+1);
		
		RestTemplate template=new RestTemplate();
		
		Map<String,Object> params=new HashMap<>();
		params.put("sabun", 1);
		params.put("ename", "한글12");
		params.put("pay", 1111);
		
		template.put(url, params);
		return null;
		
//		template.put(url, params);
//		RequestEntity entity=new RequestEntity(params, HttpMethod.PUT, url);
//		ResponseEntity<Void> result=template.exchange(url, HttpMethod.PUT, entity, Void.class);
//		return result;
	}
	
	@GetMapping("/delete/{sabun}")
	public ResponseEntity<?> delete(@PathVariable int sabun) throws URISyntaxException{
		URI url=new URI(apiPath+"/"+sabun);
		RestTemplate template=new RestTemplate();
		template.delete(url);
		return null;
	}
	
	@GetMapping("/head")
	public ResponseEntity<?> head() throws URISyntaxException{
		URI url=new URI("http://localhost:8070/api");
		
//		Map<String, Object> header=new HashMap<>();
		MultiValueMap<String,String> header= new LinkedMultiValueMap<String,String>();
		header.add("cors", "ABCD");
		
		RestTemplate template=new RestTemplate();
		
//		HttpEntity entity=new HttpEntity<>(null,header);
		HttpEntity entity=new HttpEntity<>(header);
		template.postForEntity(url, entity, null);
		return null;
		
	}
}
