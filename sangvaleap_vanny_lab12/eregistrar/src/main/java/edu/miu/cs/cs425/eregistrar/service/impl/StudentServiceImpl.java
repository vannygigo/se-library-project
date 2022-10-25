package edu.miu.cs.cs425.eregistrar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> getStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "studentNumber"));
    }

    @Override
    public Student findStudent(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        return studentRepository
                .findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(
                        searchString, searchString, searchString, searchString);
    }

    @Override
    public Page<Student> getStudentsPaged(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 2, Direction.ASC, "studentNumber"));
    }

}
