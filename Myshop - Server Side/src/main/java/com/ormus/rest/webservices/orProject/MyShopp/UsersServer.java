package com.ormus.rest.webservices.orProject.MyShopp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ormus.rest.webservices.orProject.ToDoList.ToDoTask;

@Service
public class UsersServer {
	
	private static long counter = 0;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(counter++,"ormusai35","ormusai35@gmail.com","123123"));
		users.add(new User(counter++,"hadasYziv","hadasyziv@gmail.com","Avd103"));
		users.add(new User(counter++,"lpormusa","ormusai13@walla.com","BB387886"));
	}
	
	public User getUserByEmail(String email) {
		for(User u:users) {
			if (u.getEmail().compareTo(email) == 0) {
				return u;
			} 
		}
		return null;
	}

	public boolean checkPassword(User user, String password) {
		if (user.getPassword().compareTo(password) == 0) return true;
		else return false;
	}

	public User insertNewUser(User user) {
		if (getUserByEmail(user.getEmail()) == null) {
			user.setId(counter++);
			users.add(user);
			return user;
		}
		return null;
	}

	public List<User> getAll() {
		return users;
	}
}
