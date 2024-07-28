package org.example.matricula.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.CourseDTO;
import org.example.matricula.model.Course;
import org.example.matricula.service.ICourseService;
import org.example.matricula.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
        private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
        List<CourseDTO> list = mapperUtil.mapList(service.readAll(), CourseDTO.class,"courseMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") int id) throws Exception{
        CourseDTO obj = mapperUtil.map(service.readById(id), CourseDTO.class,"courseMapper");
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(mapperUtil.map(dto, Course.class,"courseMapper"));
        return new ResponseEntity<>(mapperUtil.map(obj, CourseDTO.class,"courseMapper"),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @PathVariable("id")int id, @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.update(mapperUtil.map(dto, Course.class,"courseMapper"), id);
        return ResponseEntity.ok(mapperUtil.map(obj, CourseDTO.class,"courseMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
