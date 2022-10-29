package edu.miu.cs.cs425.eregistrarwebapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs425.eregistrarwebapi.exception.CustomNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;

@RestController
@RequestMapping(value = { "/eregistrar/api/student" })
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = { "/list" })
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping(value = { "/register" })
    public ResponseEntity<?> addNewStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @GetMapping(value = { "/get/{studentId}" })
    public ResponseEntity<?> findStudent(@PathVariable Long studentId) throws CustomNotFoundException {
        return new ResponseEntity<>(studentService.findStudent(studentId), HttpStatus.OK);
    }

    @PostMapping(value = { "/update/{studentId}" })
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student reqStudent, @PathVariable Long studentId) {
        // var student = studentService.findStudent(studentId);
        reqStudent.setStudentId(studentId);
        return new ResponseEntity<>(studentService.saveStudent(reqStudent), HttpStatus.OK);
    }

    @DeleteMapping(value = { "/delete/{studentId}" })
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) throws CustomNotFoundException {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
