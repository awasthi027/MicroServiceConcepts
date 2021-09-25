package com.ashi.learning.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ashi.learning.models.Student;


@Controller
public class HelloController {

	@RequestMapping(path = "/hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping(path = "/senddata")
	public ModelAndView sendData() {
		ModelAndView modelAndView = new ModelAndView("data");
		modelAndView.addObject("message", "Take up one idea, Make it your life");
		return modelAndView;
	}
	
	@RequestMapping(path = "/student")
	public ModelAndView requestGetStudent() {
		ModelAndView modelAndView = new ModelAndView("student");
		Student student = new Student("Abhay Shukla", "90");
		System.out.println("Student Info: =====" + student.toString());
		modelAndView.addObject("student",student);
		return modelAndView;
	}
	
	@RequestMapping(path = "/students")
	public ModelAndView requestGetStudents() {
		ModelAndView modelAndView = new ModelAndView("studentlist");
		Student abhay = new Student("Abhay Shukla", "90");
		Student abhi = new Student("Abhishek Awasthi", "92");
		List<Student> students = Arrays.asList(abhay,abhi);
		
		modelAndView.addObject("students",students);
		return modelAndView;
	}
	
	@RequestMapping(path = "/studentform")
	public ModelAndView displayStudentForm() {
		ModelAndView modelAndView = new ModelAndView("studentform");
		Student abhay = new Student("Abhay Shukla", "90");
		modelAndView.addObject("student",abhay);
		return modelAndView;
	}
	
	@RequestMapping(path = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("result");
		System.out.println("Input UserName:==== " + student.getName());
        System.out.println("Input Score:======= " + student.getScore() );
		return modelAndView;
	}
}
