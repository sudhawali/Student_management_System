package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentServiceImpl;


@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl service;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		String msg = service.addStudent(student);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		Student studentById = service.getStudentById(id);
		return new ResponseEntity<Student>(studentById,HttpStatus.OK);
	}

	
}
