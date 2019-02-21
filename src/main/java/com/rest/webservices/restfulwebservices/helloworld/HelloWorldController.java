package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloWorldController {

	// WE NEED TO DESCRIBE 3 THINGS
	// 1->METHOD I.E GET IN THIS CASE
	// 2->URI - /hello-world
	// 3->Controller

	//@GetMapping("/hello-world")
	
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	public String helloWorld() {

		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorlBean() {

		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

		return new HelloWorldBean(String.format("Hello World,%s",name));
	}

}
