package ar.edu.utn.frc.tup.piii.ba.controllers;

import ar.edu.utn.frc.tup.piii.ba.dtos.DummyDto;
import ar.edu.utn.frc.tup.piii.ba.models.DummyModel;
import ar.edu.utn.frc.tup.piii.ba.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("")
    public ResponseEntity<DummyDto> getDummys() {
        List<DummyModel> dummys = dummyService.getDummys();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DummyDto> getDummyByID(@PathVariable Long id) {
        DummyModel dummy = dummyService.getDummyByID(id);
        return null;
    }

    @PostMapping("")
    public ResponseEntity<DummyDto> createDummy(@RequestBody DummyDto dto) {
        DummyModel dummy = dummyService.createDummy(null);
        return null;
    }

    @PutMapping("")
    public ResponseEntity<DummyDto> updateDummy(@RequestBody DummyDto dto) {
        DummyModel dummy = dummyService.createDummy(null);
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteDummy(@RequestBody DummyDto dto) {
        dummyService.createDummy(null);
        return null;
    }
}
