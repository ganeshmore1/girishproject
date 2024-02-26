package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/reg")
	public  String addStudent(@RequestBody Student student)
	{
		
		service.addStudent(student);
		return "login";
	}
	@GetMapping("/getstu")
	public List<Student>getStudents(Student s)
	{
		List<Student> stu=service.getStudent(s);
		return stu;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		service.deleteStudent(id);
		return "Id Delete Successfully"+id;
	}
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student)
	{
		return service.updateData(student);
	
	}
	
	 @PostMapping("/login")
	    public String login(@RequestBody Student student) {
	        boolean loggedIn = service.login(student.getUsername(), student.getPassword());
	        if (loggedIn) {
	            return "Login successful";
	        } else {
	            return "Invalid username or password";
	        }
	    }
		/*
		 * @PostMapping("/logincheck/{username}/{password}") public String
		 * loginCheck(@RequestParam String username,String password) {
		 * service.loginCheck(username,password); return "Login Success";
		 * 
		 * }
		 */
	
}
