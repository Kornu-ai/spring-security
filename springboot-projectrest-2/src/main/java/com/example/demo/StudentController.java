package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("students")
	public List<Student> getStudents(){   //fetching all resources
		
		return studentService.getStudents();
		
	}
//	@RequestMapping("/students/{foo}")	
//	public Student getStudent(@PathVariable("foo") int id) {

	@RequestMapping("/students/{id}")   
	public Student getStudent(@PathVariable int id) {  //getting a particular resource
		return  studentService.getStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="students") //create a resource
	public void addStudent(@RequestBody Student student) {
		System.out.println("controllers add student");
		studentService.addStudent(student);
	}
	
	@RequestMapping(method =  RequestMethod.DELETE, value = "students/{id}")
	public void  deleteStudent(@PathVariable int id) {
		studentService.removeStudent(id);
	}

	
	@RequestMapping(method = RequestMethod.PUT, value = "students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable int id) {
		studentService.updateStudent(student,id);
	}
	@GetMapping("/")
	public String home() {
		return ("<h1>welcome home</h1>");
	}

	@GetMapping("/admin")
	public String admin() {
		return ("<h1>welcome admin</h1>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1>welcome user</h1>");
	}


	

}