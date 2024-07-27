package org.example.matricula.service;

import org.example.matricula.dto.CourseStudentDTO;
import org.example.matricula.model.Enrollment;

import java.util.List;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer> {

    List<CourseStudentDTO> courseStudent(Integer id) throws Exception;
}
