package org.example.matricula.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.matricula.model.Student;
import org.example.matricula.repo.IStudentRepo;
import org.example.matricula.repo.IGenericRepo;
import org.example.matricula.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() { return repo;
    }

    @Override
    public List<Student> orderDescYear() throws Exception{
        List<Student> students = repo.findAll();
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate).reversed())
                .collect(Collectors.toList());
    }


}
