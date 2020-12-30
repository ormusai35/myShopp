package com.ormus.rest.webservices.orProject.ToDoList;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class ToDoTask {
//	@Id
	@GeneratedValue
	private Long id;
//	@Column
	private String message;
//	@Column
	private Date time_to_do;
//	@Column
	private boolean isDone;
		
	protected ToDoTask() {

	}
	
	public ToDoTask(Long id,String message, Date time_to_do, boolean isDone) {
		super();
		this.id = id;
		this.message = message;
		this.time_to_do = time_to_do;
		this.isDone = isDone;
	}
	
//	public ToDoTask(ToDoTask other) {
//		this.id = other.id;
//		this.message = other.message;
//		this.time_to_do = other.time_to_do;
//		this.isDone = other.isDone;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time_to_do;
	}
	public void setTime(Date time) {
		this.time_to_do = time;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoTask other = (ToDoTask) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
