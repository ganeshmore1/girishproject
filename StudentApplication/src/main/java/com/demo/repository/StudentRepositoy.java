package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentRepositoy  extends JpaRepository<Student, Integer>{

	Student findByUsername(String username);
  public void findByUsernameAndPassword(String username,String password);
}
