package com.demo.crudwithspringboot.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.crudwithspringboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
