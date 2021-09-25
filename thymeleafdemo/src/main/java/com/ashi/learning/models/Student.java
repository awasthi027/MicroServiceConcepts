package com.ashi.learning.models;

public class Student {
	
	private String name;
	private String score;

	public Student() {
		
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

}
