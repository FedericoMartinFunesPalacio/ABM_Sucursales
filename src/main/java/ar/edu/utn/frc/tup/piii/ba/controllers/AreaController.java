package ar.edu.utn.frc.tup.piii.ba.controllers;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("")
    public ResponseEntity<List<AreaDto>> getAreas() {
        List<AreaDto> areaDto = areaService.getAllAreas();
        return ResponseEntity.ok(areaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getAreaByID(@PathVariable Long id) {
        AreaDto areaDto = areaService.getAreaById(id);
        return ResponseEntity.ok(areaDto);
    }

    @PostMapping("")
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto dto) {
        AreaDto areaDto = areaService.createArea(dto);
        return ResponseEntity.ok(areaDto);
    }
}
