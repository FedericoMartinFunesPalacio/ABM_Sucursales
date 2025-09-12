package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.entities.SucursalEntity;
import ar.edu.utn.frc.tup.piii.ba.repositories.SucursalRepository;
import ar.edu.utn.frc.tup.piii.ba.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    private SucursalDto EntityToDto(SucursalEntity entity) {
        SucursalDto dto = new SucursalDto();
        dto.setDescripcion(entity.getDescripcion());
        dto.setResponsableSucursal(entity.getResponsableSucursal());
        dto.setUbicacion(entity.getUbicacion());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setActivo(entity.getActivo());
        //LOGICA DE AREAS
        List<AreaEntity> listaAreaEntity = entity.getAreas();
        List<AreaDto> listaAreaDto = new ArrayList<>();
        for (AreaEntity area : listaAreaEntity) {
            AreaDto areaDto = new AreaDto();
            areaDto.setDescripcion(area.getDescripcion());
            listaAreaDto.add(areaDto);
        }
        dto.setAreas(listaAreaDto);
        return dto;
    }

    private SucursalEntity DtoToEntity(SucursalDto dto) {
        SucursalEntity entity = new SucursalEntity();
        entity.setDescripcion(dto.getDescripcion());
        entity.setResponsableSucursal(dto.getResponsableSucursal());
        entity.setUbicacion(dto.getUbicacion());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setActivo(dto.getActivo());
        //LOGICA DE AREAS
        List<AreaDto> listaAreaDto = dto.getAreas();
        List<AreaEntity> listaAreaEntity = new ArrayList<>();
        for (AreaDto areaDto : listaAreaDto) {
            AreaEntity areaEntity = new AreaEntity();
            areaEntity.setDescripcion(areaDto.getDescripcion());
            listaAreaEntity.add(areaEntity);
        }
        entity.setAreas(listaAreaEntity);
        return entity;
    }

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
        List<SucursalDto> listaSucursales = new ArrayList<>();
        List<SucursalEntity> listaEntities = sucursalRepository.findAll();
        for (SucursalEntity sucursal : listaEntities) {
            if(sucursal.getActivo()){ //LOGICA DE BORRADO LÓGICO
                SucursalDto sucursalDto = EntityToDto(sucursal);
                listaSucursales.add(sucursalDto);
            }
        }
        return listaSucursales;
    }

    @Override
    public SucursalDto getSucursalByID(Long sucursal_id) {
        SucursalEntity entity = sucursalRepository.findById(sucursal_id).orElse(null);
        if (entity != null && entity.getActivo()) { //LOGICA DE BORRADO LÓGICO
            SucursalDto sucursalDto = EntityToDto(entity);
            return sucursalDto;
        }
        return null; //ERROR de no encontrado
    }

    @Override
    public SucursalDto createSucursal(SucursalDto sucursalDto) {
        if(Validate(sucursalDto)){
            SucursalEntity entity = DtoToEntity(sucursalDto);
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
                entity = DtoToEntity(sucursalDto);
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
