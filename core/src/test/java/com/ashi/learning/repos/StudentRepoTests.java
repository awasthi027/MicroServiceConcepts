package com.ashi.learning.repos;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashi.learning.models.Student;
import com.ashi.learning.respository.StudentRepo;

@SpringBootTest
class StudentRepoTests {

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Test
	void saveStudentInfo() {
		Student student = new Student();
		student.setName("Raggu");
		student.setTestScore(50);
		studentRepo.save(student);
		
		Optional<Student> saveStudent = studentRepo.findById(1l);
		
		assertNotNull(saveStudent);
	}
	
	@Test
	void updateStudentInfo() {
		Optional<Student> saveStudent = studentRepo.findById(1l);
	    if (saveStudent.isPresent()) {
	     Student updteStudent =	saveStudent.get();
	     updteStudent.setName("Nirmal Kishor");
	     Student savedNameStudent = studentRepo.save(updteStudent);
	     assertEquals("Nirmal Kishor", savedNameStudent.getName());
	    }
		
	}

}
