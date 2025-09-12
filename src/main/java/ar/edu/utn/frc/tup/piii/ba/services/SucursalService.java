package ar.edu.utn.frc.tup.piii.ba.services;
import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SucursalService {
    List<SucursalDto> getSucursales();

    SucursalDto getSucursalByID(Long sucursal_id);

    SucursalDto createSucursal (SucursalDto sucursalDto);

    SucursalDto updateSucursal (Long id ,SucursalDto sucursalDto);

    void deleteSucursal(Long sucursal_id);
}
