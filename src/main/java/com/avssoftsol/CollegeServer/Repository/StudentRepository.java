package com.avssoftsol.CollegeServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avssoftsol.CollegeServer.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
