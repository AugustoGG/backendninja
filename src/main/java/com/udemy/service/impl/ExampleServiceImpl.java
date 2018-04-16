package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

//Genera un BIN que se va iniciar al arracque del servidor 
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Lalo", 22));
		people.add(new Person("Lola", 21));
		people.add(new Person("Lalo", 23));
		people.add(new Person("Lola", 22));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
//En los servicios se lleva toda la lógica de programacion 
