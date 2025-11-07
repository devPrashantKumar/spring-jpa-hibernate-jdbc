package com.thecodeexperience.JPADemo03.Repository;

import com.thecodeexperience.JPADemo03.Entity.Address;
import com.thecodeexperience.JPADemo03.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
