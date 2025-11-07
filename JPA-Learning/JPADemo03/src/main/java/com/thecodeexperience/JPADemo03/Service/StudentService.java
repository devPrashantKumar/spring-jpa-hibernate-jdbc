package com.thecodeexperience.JPADemo03.Service;

import com.thecodeexperience.JPADemo03.Entity.Address;
import com.thecodeexperience.JPADemo03.Entity.Student;
import com.thecodeexperience.JPADemo03.Repository.AddressRepository;
import com.thecodeexperience.JPADemo03.Repository.StudentRepository;
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

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
