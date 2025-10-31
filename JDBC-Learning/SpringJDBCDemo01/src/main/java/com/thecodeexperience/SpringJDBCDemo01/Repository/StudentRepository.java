package com.thecodeexperience.SpringJDBCDemo01.Repository;

import com.thecodeexperience.SpringJDBCDemo01.Entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> rowMapper = (rs, rowNum) ->
            new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", rowMapper);
    }

    public Student findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM students WHERE id = ?",
                new Object[]{id},
                rowMapper
        );
    }

    public int save(Student student) {
        return jdbcTemplate.update(
                "INSERT INTO students(name, email) VALUES (?, ?)",
                student.getName(), student.getEmail()
        );
    }

    public int update(Student student) {
        return jdbcTemplate.update(
                "UPDATE students SET name=?, email=? WHERE id=?",
                student.getName(), student.getEmail(), student.getId()
        );
    }

    public int deleteById(int id) {
        return jdbcTemplate.update(
                "DELETE FROM students WHERE id=?",
                id
        );
    }
}

