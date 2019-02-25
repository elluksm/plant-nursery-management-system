package com.elina.acnspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elina.acnspring.jpa.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}