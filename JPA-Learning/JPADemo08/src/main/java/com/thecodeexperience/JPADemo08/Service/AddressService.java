package com.thecodeexperience.JPADemo08.Service;

import com.thecodeexperience.JPADemo08.Entity.Address;
import com.thecodeexperience.JPADemo08.Repository.AddressRepository;
import com.thecodeexperience.JPADemo08.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        addresses.forEach(address -> address.getStudents().forEach(student -> student.setAddresses(null)));
        return  addresses;
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        address.getStudents().forEach(student -> student.setAddresses(List.of(address)));
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
