package com.demo.crudwithspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.crudwithspringboot.model.Student;
import com.demo.crudwithspringboot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = {"/", "/students"})
	public String findAllStudents(Model model) {
		List<Student> students = studentService.findAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping("/add-student")
	public String addStudent(Student student) {
		return "add-student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(Model model, Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "add-student";
		}
		studentService.saveStudent(student);
		model.addAttribute("students", studentService.findAllStudents());
		return "redirect:/students";
	}
	
	@GetMapping("update-student/{id}") 
	public String studentUpdate(@PathVariable Long id, Model model) {
		Student student = studentService.findStudentById(id);
		model.addAttribute("student", student);
		return "update-student";
	}
	
	@PostMapping("/new-update-student/{id}")
	public String newUpdateStudent(@PathVariable Long id, Model model, Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "update-student";
		}
		studentService.updateStudent(student);
		model.addAttribute("students", studentService.findAllStudents());
		return "redirect:/students";
	}
	
	@GetMapping("/remove-student/{id}")
	public String removeStudent(@PathVariable Long id, Model model) {
		studentService.deleteStudent(id);
		model.addAttribute("students", studentService.findAllStudents());
		return "redirect:/students";
	}
}
