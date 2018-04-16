package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	@Qualifier("exampleService")
	//Se declara la interface
	private ExampleService exampleService;
	
	//Indica a spring que vamos a inyectar un componente que se encuentra en su memoria
	@Autowired
	//Indica el nombre del bin que está en su memoria
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	public static final String EXAMPLE_VIEW = "Example";

	//Primera Forma para cuando se hacer redirecciones o hay que insertar muy pocos datos
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	//anotacion hijo
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda Forma para cuando hay que insertar datos en las plantillas 
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
}
//El controller solo llama a servicios