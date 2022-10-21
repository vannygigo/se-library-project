package edu.miu.cs.cs425.eregistrar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.eregistrar.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(
            String sutdentNumber, String firstName, String middleName, String lastName);
}
