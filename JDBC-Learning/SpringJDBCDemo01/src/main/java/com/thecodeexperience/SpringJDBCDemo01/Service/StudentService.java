package com.thecodeexperience.SpringJDBCDemo01.Service;

import com.thecodeexperience.SpringJDBCDemo01.Entity.Student;
import com.thecodeexperience.SpringJDBCDemo01.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public void createStudent(Student student) {
        repository.save(student);
    }

    public void updateStudent(Student student) {
        repository.update(student);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
