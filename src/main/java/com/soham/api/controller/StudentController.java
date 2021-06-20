package com.soham.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.soham.api.entity.Student;
import com.soham.api.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> list=studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		Student s=studentService.createStudent(student);
		return new ResponseEntity<Student>(s,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>  getStudent(@PathVariable Integer id)
	{
		Student s=studentService.getStudent(id);
		return new ResponseEntity<Student>(s,new HttpHeaders(),HttpStatus.OK);
	}
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		Student updateStudent = studentService.updateStudent(student);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.OK);
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

}
