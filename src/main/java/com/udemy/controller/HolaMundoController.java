package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/say")
public class HolaMundoController {
		@GetMapping("/HolaMundo")
		public String helloWorld() {
			return "HolaMundo";
		}
}
