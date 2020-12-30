package com.ormus.rest.webservices.orProject.MyShopp;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ormus.rest.webservices.orProject.ToDoList.ToDoTask;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UsersController {
	
	@Autowired
	private UsersServer Userver;
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return Userver.getAll();
	} 
	
	@GetMapping(path = "/user/{email}/{password}")
	public User getUser(@PathVariable String email,@PathVariable String password) {
		User user = Userver.getUserByEmail(email);
		if (user != null && Userver.checkPassword(user,password)) return user;
		return null;
	}
	
	@PostMapping(path = "/user")
	public User insertNewUser(@RequestBody User user){

		User insertUser = Userver.insertNewUser(user);
		return insertUser;
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertUser.getId()).toUri();
//		return ResponseEntity.created(uri).build();
	} 
	
}
