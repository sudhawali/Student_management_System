package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentCrudOperationApplicationTests {
	
	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepository repository;

	@Test
	public void addStudent() {
		Student s = new Student(101, "Amit", "amit@gmail.com");
		when(repository.save(s)).thenReturn(s);
		String expected = "Student Saved";
		String actual = service.addStudent(s);
		
		assertEquals(expected , actual);
		
	}

}
