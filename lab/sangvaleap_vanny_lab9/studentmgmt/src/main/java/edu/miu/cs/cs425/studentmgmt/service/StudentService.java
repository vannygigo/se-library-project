package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    Iterable<Student> getStudents();
}
