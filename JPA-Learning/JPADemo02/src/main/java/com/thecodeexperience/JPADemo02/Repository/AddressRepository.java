package com.thecodeexperience.JPADemo02.Repository;

import com.thecodeexperience.JPADemo02.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Student, Long> {
}
