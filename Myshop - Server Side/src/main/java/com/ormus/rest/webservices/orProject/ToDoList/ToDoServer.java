package com.ormus.rest.webservices.orProject.ToDoList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoServer {
	
	private static long counter = 0;
	private static List<ToDoTask> todos = new ArrayList<>();
	
	static {
		todos.add(new ToDoTask(++counter,"learn angular", new Date(), false));
		todos.add(new ToDoTask(++counter,"play football",new Date(), false));
		todos.add(new ToDoTask(++counter,"view a movie",new Date(), false));
	}
	
	public List<ToDoTask> getAll(){
		return todos;
	}

	public ToDoTask getToDoById(Long id) {
		for (ToDoTask toDoTask : todos) {
			if (toDoTask.getId() == id) return toDoTask;
		}
		return null;
	}
	
	public ToDoTask deleteById(Long id) {
		ToDoTask todo = getToDoById(id);
		if (todo == null) return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public ToDoTask updateToDo(ToDoTask todo) {
		if (todo.getId() <= 0) {
			todo.setId(++counter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	


}
