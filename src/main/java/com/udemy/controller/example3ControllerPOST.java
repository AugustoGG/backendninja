package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class example3ControllerPOST {
	
	
	private static final Log LOGGER = LogFactory.getLog(example3ControllerPOST.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	
	//REDIRECCIONES:
	
	//FORMA 1
	/*@GetMapping("/")
	public String redireccion() {
		return "redirect:/example3/showform";
	}*/
	
	//FORMA 2
	@GetMapping("/")
	public RedirectView redireccion() {
		return new RedirectView("/example3/showform");
	}
	
	//Muestra el formulario
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO_TRACE");
		LOGGER.warn("ERROR_TRACE");
		LOGGER.error("ERROR_TACE");
		LOGGER.debug("DEBUG_TRACE");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	
	//Muestra peticion POST
	@PostMapping("/addperson")
	//@Valid para validar los campos en el modelo de Spring 
	//y pasar por parametro el BindingResult 
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bidingResult) {
		ModelAndView mav = new ModelAndView();
		if(bidingResult.hasErrors()){
			mav.setViewName(FORM_VIEW);;
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		
		/*LOGGER.info("METHOD: 'addPerson'  -- PARAMS: '" + person + "'");
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		LOGGER.info("TEMPLETE: '"+ RESULT_VIEW + "' --- DATA: '"+ person + "'");*/
		return mav;
	}
}
