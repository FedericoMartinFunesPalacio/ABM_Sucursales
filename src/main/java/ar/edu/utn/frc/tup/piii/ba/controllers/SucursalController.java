package ar.edu.utn.frc.tup.piii.ba.controllers;

import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;
import ar.edu.utn.frc.tup.piii.ba.services.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
@RequiredArgsConstructor
public class SucursalController{

    private final SucursalService sucursalService;

    @GetMapping("")
    public ResponseEntity<List<SucursalDto>> getSucursales() {
        List<SucursalDto> dto = sucursalService.getSucursales();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDto> getSucursalByID(@PathVariable Long id) {
        SucursalDto dto = sucursalService.getSucursalByID(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<SucursalDto> createSucursal(@RequestBody SucursalDto dto) {
        SucursalDto dtos = sucursalService.createSucursal(dto);
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable Long id, @RequestBody SucursalDto dto) {
        SucursalDto dtos = sucursalService.updateSucursal(id, dto);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok(null);
    }
}
