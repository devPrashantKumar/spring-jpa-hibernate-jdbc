package com.thecodeexperience.JPADemo04.Repository;

import com.thecodeexperience.JPADemo04.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
