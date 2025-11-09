package com.thecodeexperience.JPADemo05.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecodeexperience.JPADemo05.CO.StudentCO;
import com.thecodeexperience.JPADemo05.Entity.Address;
import com.thecodeexperience.JPADemo05.Entity.Student;
import com.thecodeexperience.JPADemo05.Repository.AddressRepository;
import com.thecodeexperience.JPADemo05.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return  addresses;
    }

    public Student updateStudent(StudentCO studentCO) {
        Student student = Student.builder().id(studentCO.getId())
                .name(studentCO.getName())
                .email(studentCO.getEmail())
                .addresses(studentCO.getAddresses().stream().map((addressCO)->
                    Address.builder().id(addressCO.getId())
                            .city(addressCO.getCity())
                            .street(addressCO.getStreet())
                            .zipcode(addressCO.getZipcode())
                            .build()
                ).toList()).build();
        for(Address address : student.getAddresses()) address.setStudent(student);
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        for(Address address : student.getAddresses()) address.setStudent(student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
