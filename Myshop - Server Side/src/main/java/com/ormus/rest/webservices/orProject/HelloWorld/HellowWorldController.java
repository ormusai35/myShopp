package com.ormus.rest.webservices.orProject.HelloWorld;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HellowWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public hellowWorldBean helloWorldBean() {
		return new hellowWorldBean("hello world bean");
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public hellowWorldBean helloWorldPathVariable(@PathVariable String name){
//		return new RuntimeException("wrong way");
		return new hellowWorldBean(String.format("hello world %s", name));
	}

}
