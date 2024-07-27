package org.example.matricula.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.CourseStudentDTO;
import org.example.matricula.model.*;
import org.example.matricula.repo.IEnrollmentRepo;
import org.example.matricula.repo.IGenericRepo;
import org.example.matricula.service.IEnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<CourseStudentDTO> courseStudent(Integer id) throws Exception {
        List<Enrollment> enrollments = repo.findAll();
       List<CourseStudentDTO> p= enrollments.stream().map(e -> {
            CourseStudentDTO courseStudentDTO= null;
           List<Course> cursos =  e.getDetails().stream().filter(d -> d.getCourse().getIdCourse().equals(id)).map(c ->{
               return c.getCourse();
           }).toList();
            if(cursos.size()>0) {
                courseStudentDTO= new CourseStudentDTO();
                courseStudentDTO.setCourse(cursos);
                courseStudentDTO.setStudent(e.getStudent());
            }
            return courseStudentDTO;
        }).collect(Collectors.toList());

        return p.stream().filter( o -> o != null).toList();
    }
}
