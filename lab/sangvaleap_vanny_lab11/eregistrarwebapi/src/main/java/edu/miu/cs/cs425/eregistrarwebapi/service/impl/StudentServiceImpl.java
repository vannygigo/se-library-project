package edu.miu.cs.cs425.eregistrarwebapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.eregistrarwebapi.exception.CustomNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;

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
    public Student findStudent(Long studentId) throws CustomNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new CustomNotFoundException(
                        String.format("Student with Id: %d is not found", studentId)));
    }

    @Override
    public void deleteStudent(Long studentId) {
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
