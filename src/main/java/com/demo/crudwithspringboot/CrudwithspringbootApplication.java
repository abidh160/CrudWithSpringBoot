package com.demo.crudwithspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.crudwithspringboot.model.Student;
import com.demo.crudwithspringboot.service.StudentService;


@SpringBootApplication
public class CrudwithspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudwithspringbootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initialCreate(StudentService studentService) {
		return (args) -> {
			Student student1 = new Student("Ali", "Khan", 19, "alikhan@gmail.com");
			Student student2 = new Student("John", "Doe", 55, "johndoe@gmail.com");
			Student student3 = new Student("Addy", "Sean", 43, "addysean@gmail.com");
			studentService.saveStudent(student1);
			studentService.saveStudent(student2);
			studentService.saveStudent(student3);
		};
	}
	
}
