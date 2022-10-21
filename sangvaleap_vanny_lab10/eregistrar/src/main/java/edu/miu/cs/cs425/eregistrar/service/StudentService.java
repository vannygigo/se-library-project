package edu.miu.cs.cs425.eregistrar.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.eregistrar.model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    Iterable<Student> getStudents();

    Page<Student> getStudentsPaged(int pageNo);

    Student findStudent(Long studentId);

    void deleteStudent(Long studentId);

    Iterable<Student> searchStudents(String searchString);
}
