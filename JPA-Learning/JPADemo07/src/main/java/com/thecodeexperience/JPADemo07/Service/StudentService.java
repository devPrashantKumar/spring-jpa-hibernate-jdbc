package com.thecodeexperience.JPADemo07.Service;

import com.thecodeexperience.JPADemo07.Entity.Address;
import com.thecodeexperience.JPADemo07.Entity.Student;
import com.thecodeexperience.JPADemo07.Repository.AddressRepository;
import com.thecodeexperience.JPADemo07.Repository.StudentRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return  students;
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        List<Address> addresses = new ArrayList<>();
        if(!student.getAddresses().isEmpty()){
            List<Address> managedAddresses = addressRepository.findAllById(
                    student.getAddresses().stream().map(Address::getId).filter(Objects::nonNull).toList()
            );
            Map<Long,Address> addressMap = managedAddresses.stream().collect(Collectors.toMap(Address::getId, Function.identity(),((address, address2) -> address)));
            for(Address address : student.getAddresses()){
                if(Objects.nonNull(address.getId())){
                    Address address1 = addressMap.get(address.getId());
                    address1.setCity(address.getCity());
                    address1.setStreet(address.getStreet());
                    address1.setZipcode(address.getZipcode());
                    addresses.add(address1);
                }
                else addresses.add(address);
            }
            student.setAddresses(addresses);
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
