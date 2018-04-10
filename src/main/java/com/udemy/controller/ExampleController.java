package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	public static final String EXAMPLE_VIEW = "Example";

	//Primera Forma para cuando se hacer redirecciones o hay que insertar muy pocos datos
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	//anotacion hijo
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda Forma para cuando hay que insertar datos en las plantillas 
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Lalo", 22));
		people.add(new Person("Lola", 21));
		people.add(new Person("Lalo", 23));
		people.add(new Person("Lola", 22));
		return people;
	}
	
}
