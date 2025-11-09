package com.thecodeexperience.JPADemo05.Controller;

import com.thecodeexperience.JPADemo05.CO.StudentCO;
import com.thecodeexperience.JPADemo05.Entity.Address;
import com.thecodeexperience.JPADemo05.Entity.Student;
import com.thecodeexperience.JPADemo05.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ✅ Create a new student with address
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody StudentCO studentCO) {
        return ResponseEntity.ok(studentService.updateStudent(studentCO));
    }

    // ✅ Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(studentService.getAllAddresses());
    }

    // ✅ Get a single student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
