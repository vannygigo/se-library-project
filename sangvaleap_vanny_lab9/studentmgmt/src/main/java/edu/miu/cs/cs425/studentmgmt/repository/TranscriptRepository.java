package edu.miu.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Long> {

}
