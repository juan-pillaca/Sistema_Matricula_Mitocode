package org.example.matricula.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.StudentDTO;
import org.example.matricula.model.Student;
import org.example.matricula.service.IStudentService;
import org.example.matricula.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
        private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = mapperUtil.mapList(service.readAll(), StudentDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/order")
    public ResponseEntity<List<StudentDTO>> orderDescYear() throws Exception {
        List<StudentDTO> list = mapperUtil.mapList(service.orderDescYear(), StudentDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") int id) throws Exception{
        StudentDTO obj = mapperUtil.map(service.readById(id), StudentDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(mapperUtil.map(dto, Student.class));
        return new ResponseEntity<>(mapperUtil.map(obj, StudentDTO.class),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @PathVariable("id")int id, @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.update(mapperUtil.map(dto, Student.class), id);
        return ResponseEntity.ok(mapperUtil.map(obj, StudentDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
