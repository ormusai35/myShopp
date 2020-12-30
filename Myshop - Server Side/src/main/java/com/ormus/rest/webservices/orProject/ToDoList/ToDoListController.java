package com.ormus.rest.webservices.orProject.ToDoList;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ToDoListController {
	
	@Autowired
	private ToDoServer server;
	
//	@GetMapping(path = "/hello-world")
//	public String setHello(){
//		return "hello world";
//	} 
	
	
	@GetMapping(path = "/ToDoList")
	public List<ToDoTask> getToDoList(){
		return server.getAll();
	} 
	
	@GetMapping(path = "/ToDoList/{id}")
	public ToDoTask getToDo(@PathVariable long id){
		ToDoTask todo = server.getToDoById(id);
		if (todo != null) return todo;
		return null;
	} 
	
	@DeleteMapping(path = "/ToDoList/{id}")
	public ResponseEntity<Void> deleteToDoList(@PathVariable long id){
		ToDoTask deletedToDo = server.deleteById(id);
		if (deletedToDo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	} 
	
	@PutMapping(path = "/ToDoList/{id}")
	public ResponseEntity<ToDoTask> updateToDoList(@PathVariable long id,@RequestBody ToDoTask todo){
		
		ToDoTask updatedToDo = server.updateToDo(todo);
		return new ResponseEntity<ToDoTask>(todo,HttpStatus.OK);
	} 

	@PostMapping(path = "/ToDoList")
	public ResponseEntity<Void> insertToDoList(@RequestBody ToDoTask todo){
		
		ToDoTask insertToDo = server.updateToDo(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertToDo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	} 
}
