package com.thecodeexperience.JPADemo04.Repository;

import com.thecodeexperience.JPADemo04.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
