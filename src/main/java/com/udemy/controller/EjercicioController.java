package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	public static final String MENSAJE_VIEW= "mensaje";
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	
	@GetMapping("/primero")
	public String metodoUno() {
		return "redirect:/ejercicio/segundo";
	}
	
	@GetMapping("/segundo")
	public String metodoDos() {
		ejercicioService.servicioLog();
		return (MENSAJE_VIEW);
	}

}
