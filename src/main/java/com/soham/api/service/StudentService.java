package com.soham.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soham.api.entity.Student;
import com.soham.api.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList<>();
		studentRepository.findAll().forEach(e->list.add(e));
		return list;
	}
	public Student createStudent(Student student)
	{
		Student s=studentRepository.save(student);
		return s;
	}
	public Student getStudent(int id)
	{
		Student s=studentRepository.getById(id);
		return s;
		//Optional<Student> student = studentRepositori.findById(id);
		//return student.get();

		  
	}
	public Student updateStudent(Student student)
	{
		Student student2 = studentRepository.save(student);
		return student2;
	}
	public void deleteStudent(int id)
	{
		studentRepository.delete(getStudent(id));
	}
	

}
