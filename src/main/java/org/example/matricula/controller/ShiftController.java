package org.example.matricula.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matricula.dto.ShiftDTO;
import org.example.matricula.model.Shift;
import org.example.matricula.service.IShiftService;
import org.example.matricula.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
@RequiredArgsConstructor
public class ShiftController {

    private final IShiftService service;
        private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ShiftDTO>> readAll() throws Exception{
        List<ShiftDTO> list = mapperUtil.mapList(service.readAll(), ShiftDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftDTO> readById(@PathVariable("id") int id) throws Exception{
        ShiftDTO obj = mapperUtil.map(service.readById(id), ShiftDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<ShiftDTO> save(@Valid @RequestBody ShiftDTO dto) throws Exception{
        Shift obj = service.save(mapperUtil.map(dto, Shift.class));
        return new ResponseEntity<>(mapperUtil.map(obj, ShiftDTO.class),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftDTO> update(@Valid @PathVariable("id")int id, @RequestBody ShiftDTO dto) throws Exception{
        Shift obj = service.update(mapperUtil.map(dto, Shift.class), id);
        return ResponseEntity.ok(mapperUtil.map(obj, ShiftDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
