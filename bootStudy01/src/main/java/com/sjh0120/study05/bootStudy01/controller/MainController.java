package com.sjh0120.study05.bootStudy01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String index() {
		return "home";
	}
}
