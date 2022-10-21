package edu.miu.cs.cs425.eregistrarwebapi.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.eregistrarwebapi.exception.CustomNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    Iterable<Student> getStudents();

    Page<Student> getStudentsPaged(int pageNo);

    Student findStudent(Long studentId) throws CustomNotFoundException;

    void deleteStudent(Long studentId);

    Iterable<Student> searchStudents(String searchString);
}
