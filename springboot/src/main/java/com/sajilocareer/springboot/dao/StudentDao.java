package com.sajilocareer.springboot.dao;

import com.sajilocareer.springboot.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {
    List<Student> findByName(String name);
}
