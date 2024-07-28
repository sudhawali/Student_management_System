package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public String addStudent(Student student) {
		repository.save(student);
		return "Student Saved";
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> byId = repository.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	
}
