package edu.miu.cs.cs425.studentmgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Iterable<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

}
