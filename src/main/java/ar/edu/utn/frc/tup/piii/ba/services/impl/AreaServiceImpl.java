package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.repositories.AreaRepository;
import ar.edu.utn.frc.tup.piii.ba.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public AreaDto createArea(AreaDto areaDto) {
        AreaEntity entity = new AreaEntity();
        entity.setDescripcion(areaDto.getDescripcion());
        AreaEntity savedEntity = areaRepository.save(entity);
        return new AreaDto(savedEntity.getDescripcion());
    }

    @Override
    public AreaDto getAreaById(Long area_id) {
        AreaEntity entity = areaRepository.findById(area_id).orElse(null);
        if (entity != null) {
            return new AreaDto(entity.getDescripcion());
        }
        return null;
    }

    @Override
    public List<AreaDto> getAllAreas() {
        List<AreaDto> listaAreas = new ArrayList<AreaDto>();
        List <AreaEntity> entities = areaRepository.findAll();
        for (AreaEntity entity : entities) {
            AreaDto dto = new AreaDto(entity.getDescripcion());
            listaAreas.add(dto);
        }
        return listaAreas;
    }
}
