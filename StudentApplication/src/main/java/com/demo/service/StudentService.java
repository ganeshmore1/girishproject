package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepositoy;

@Service
public class StudentService {

	@Autowired
     private StudentRepositoy repository;
	
	public String addStudent(Student student)
	{
		 repository.save(student);
		return null;
		 
	}
	public List<Student> getStudent(Student student)
	{
		List<Student> stud=repository.findAll();
		return stud;
	}
	
	public String deleteStudent(Integer id)
	{
	     repository.deleteById(id);
 		return "delete"+id;
	}
	public Student updateData(Student student)
	{
		Student exitingpro=repository.findById(student.getId()).orElse(student);
		exitingpro.setName(student.getName());
		exitingpro.setAddress(student.getAddress());
	return 	repository.save(student);
		
	}
	
	public boolean login(String username, String password) {
        Student student = repository.findByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
	/*
	 * public void loginCheck(String username, String password) { // TODO
	 * Auto-generated method stub repository.findByUsernameAndPassword(username,
	 * password); }
	 */
}
