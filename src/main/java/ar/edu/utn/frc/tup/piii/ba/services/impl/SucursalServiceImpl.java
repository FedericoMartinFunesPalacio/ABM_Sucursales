package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.entities.SucursalEntity;
import ar.edu.utn.frc.tup.piii.ba.mapers.SucursalMapper;
import ar.edu.utn.frc.tup.piii.ba.repositories.SucursalRepository;
import ar.edu.utn.frc.tup.piii.ba.services.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    private Boolean Validate(SucursalDto dto) {
        if(dto.getDescripcion() == null || dto.getDescripcion().isBlank()) return false;
        if(dto.getResponsableSucursal() == null || dto.getResponsableSucursal().isBlank()) return false;
        if(dto.getUbicacion() == null || dto.getUbicacion().isBlank()) return false;
        if(dto.getCorreo() == null || dto.getCorreo().isBlank()) return false;
        if(dto.getTelefono() == null || dto.getTelefono().isBlank()) return false;
        if(dto.getActivo() == null) return false;
        //LOGICA DE AREAS
        List<AreaDto> listaAreaDto = dto.getAreas();
        if(listaAreaDto == null) return false;
        for (AreaDto areaDto : listaAreaDto) {
            if(areaDto.getDescripcion() == null || areaDto.getDescripcion().isBlank()) return false;
        }
        return true;
    } //CORROBORAR DE AGREGAR MAS VALIDACIONES

    @Override
    public List<SucursalDto> getSucursales() {
        return sucursalRepository.findAll().stream()
                .map(SucursalMapper::toSucursalDto).toList();
    }

    @Override
    public SucursalDto getSucursalByID(Long sucursal_id) {
        SucursalEntity entity = sucursalRepository.findById(sucursal_id).orElse(null);
        if (entity != null && entity.getActivo()) { //LOGICA DE BORRADO LÓGICO
            return SucursalMapper.toSucursalDto(entity);
        }
        return null; //ERROR de no encontrado
    }

    @Override
    public SucursalDto createSucursal(SucursalDto sucursalDto) {
        if(Validate(sucursalDto)){
            SucursalEntity entity = SucursalMapper.toSucursalEntity(sucursalDto);
            SucursalEntity sucursalGuardada = sucursalRepository.save(entity);
            return getSucursalByID(sucursalGuardada.getId());
        }
        return null;//ERROR de validacion
    }

    @Override
    public SucursalDto updateSucursal(Long id ,SucursalDto sucursalDto) {
        if(Validate(sucursalDto)){
            SucursalEntity entity = sucursalRepository.findById(id).orElse(null);
            if (entity != null && entity.getActivo()) {
                entity = SucursalMapper.toSucursalEntity(sucursalDto);
                SucursalEntity sucursalGuardada = sucursalRepository.save(entity);
                return getSucursalByID(sucursalGuardada.getId());
            }
            return null; //ERROR de no encontrado
        }
        return null; //ERROR de validacion
    }

    @Override
    public void deleteSucursal(Long sucursal_id) {
        SucursalEntity entity = sucursalRepository.findById(sucursal_id).orElse(null);
        if (entity != null) {
            entity.setActivo(false);
            sucursalRepository.save(entity);
        }
    }
}
