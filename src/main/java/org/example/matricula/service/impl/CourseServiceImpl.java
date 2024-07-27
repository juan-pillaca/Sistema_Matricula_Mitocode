package org.example.matricula.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.matricula.model.Course;
import org.example.matricula.repo.ICourseRepo;
import org.example.matricula.repo.IGenericRepo;
import org.example.matricula.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() { return repo;
    }
}
