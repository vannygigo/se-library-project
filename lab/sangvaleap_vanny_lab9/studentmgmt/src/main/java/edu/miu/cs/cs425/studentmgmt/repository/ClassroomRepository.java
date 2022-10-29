package edu.miu.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

}
