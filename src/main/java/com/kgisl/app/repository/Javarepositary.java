package com.kgisl.app.repository;

import com.kgisl.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Javarepositary extends JpaRepository<Student, Long> {

    
}