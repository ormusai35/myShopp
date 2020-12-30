package com.ormus.rest.webservices.orProject.Products;

import java.util.HashMap;

public class Cart {
	private String date;
	private HashMap<Long, Integer> items = new HashMap<>();
	
	public Cart(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public HashMap<Long, Integer> getItems() {
		return items;
	}
	
	

}
