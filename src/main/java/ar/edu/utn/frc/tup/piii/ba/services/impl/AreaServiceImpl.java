package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.mapers.AreaMapper;
import ar.edu.utn.frc.tup.piii.ba.repositories.AreaRepository;
import ar.edu.utn.frc.tup.piii.ba.services.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    public AreaDto createArea(AreaDto areaDto) {
        AreaEntity entity = new AreaEntity();
        entity.setDescripcion(areaDto.getDescripcion());
        AreaEntity savedEntity = areaRepository.save(entity);
        return new AreaDto(savedEntity.getDescripcion());
    }

    @Override
    public AreaDto getAreaById(Long area_id) {
        return areaRepository.findById(area_id)
                .map(AreaMapper::toAreaDto).orElse(null);
    }

    @Override
    public List<AreaDto> getAllAreas() {
        return areaRepository.findAll()
                .stream().map(AreaMapper::toAreaDto).collect(Collectors.toList());
    }
}
