package com.thecodeexperience.JPADemo06.Service;

import com.thecodeexperience.JPADemo06.Entity.Address;
import com.thecodeexperience.JPADemo06.Entity.Student;
import com.thecodeexperience.JPADemo06.Repository.AddressRepository;
import com.thecodeexperience.JPADemo06.Repository.StudentRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;

    public AddressService(AddressRepository addressRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }

    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return  addresses;
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        if(!Objects.isNull(address.getStudent().getId())){
            Student student = studentRepository.getReferenceById(address.getStudent().getId());
            Hibernate.initialize(student);
            student.setEmail(address.getStudent().getEmail());
            student.setName(address.getStudent().getName());
            address.setStudent(student);
        }
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
