package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class Example4Controller {

	private static final String ERROR_500 = "error/500";
	private static final String ERROR_404 = "error/404";
	
	@GetMapping("/500")
	public String error505() {
		return ERROR_500;
	}
	
	@GetMapping("/404")
	public String error404() {
		return ERROR_404;
	}
	
}
