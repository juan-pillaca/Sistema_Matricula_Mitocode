package org.example.matricula.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.CareerDTO;
import org.example.matricula.model.Career;
import org.example.matricula.service.ICareerService;
import org.example.matricula.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
@RequiredArgsConstructor
public class CareerController {

    private final ICareerService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CareerDTO>> readAll() throws Exception{
        List<CareerDTO> list = mapperUtil.mapList(service.readAll(), CareerDTO.class,"careerMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerDTO> readById(@PathVariable("id") int id) throws Exception{
        CareerDTO obj = mapperUtil.map(service.readById(id), CareerDTO.class,"careerMapper");
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CareerDTO> save(@Valid @RequestBody CareerDTO dto) throws Exception{
        Career obj = service.save(mapperUtil.map(dto, Career.class,"careerMapper"));
        return new ResponseEntity<>(mapperUtil.map(obj, CareerDTO.class,"careerMapper"),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerDTO> update(@Valid @PathVariable("id")int id, @RequestBody CareerDTO dto) throws Exception{
        Career obj = service.update(mapperUtil.map(dto, Career.class,"careerMapper"), id);
        return ResponseEntity.ok(mapperUtil.map(obj, CareerDTO.class,"careerMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
