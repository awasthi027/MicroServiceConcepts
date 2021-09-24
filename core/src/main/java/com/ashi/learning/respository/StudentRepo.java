package com.ashi.learning.respository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashi.learning.models.Student;


public interface StudentRepo extends JpaRepository<Student, Long> {
 
}
