package com.ashi.learning.models;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Person() { }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
