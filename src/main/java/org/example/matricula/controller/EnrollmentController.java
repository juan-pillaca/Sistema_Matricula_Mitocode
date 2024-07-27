package org.example.matricula.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.CourseStudentDTO;
import org.example.matricula.dto.EnrollmentDTO;
import org.example.matricula.model.Enrollment;
import org.example.matricula.service.IEnrollmentService;
import org.example.matricula.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
        private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{
        List<EnrollmentDTO> list = mapperUtil.mapList(service.readAll(), EnrollmentDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/coursestudent/{id}")
   public ResponseEntity<List<CourseStudentDTO>> courseStudent(@PathVariable Integer id) throws Exception{
                return ResponseEntity.ok(service.courseStudent(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") int id) throws Exception{
        EnrollmentDTO obj = mapperUtil.map(service.readById(id), EnrollmentDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.save(mapperUtil.map(dto, Enrollment.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EnrollmentDTO.class),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @PathVariable("id")int id, @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.update(mapperUtil.map(dto, Enrollment.class), id);
        return ResponseEntity.ok(mapperUtil.map(obj, EnrollmentDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
