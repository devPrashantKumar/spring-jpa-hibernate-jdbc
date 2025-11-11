package com.thecodeexperience.JPADemo07.Repository;

import com.thecodeexperience.JPADemo07.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
