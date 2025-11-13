package com.thecodeexperience.JPADemo09.Repository;

import com.thecodeexperience.JPADemo09.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
