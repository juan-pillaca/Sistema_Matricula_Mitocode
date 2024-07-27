package org.example.matricula.service;

import org.example.matricula.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    List<Student> orderDescYear() throws Exception;
}
