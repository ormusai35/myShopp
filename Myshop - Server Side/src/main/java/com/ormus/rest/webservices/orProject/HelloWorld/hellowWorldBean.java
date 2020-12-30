package com.ormus.rest.webservices.orProject.HelloWorld;

public class hellowWorldBean{

	private String string;

	public hellowWorldBean(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "hellowWorldBean [string=" + string + "]";
	}
	
}
