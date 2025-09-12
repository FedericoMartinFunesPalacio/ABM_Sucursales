package ar.edu.utn.frc.tup.piii.ba.services;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {
    AreaDto createArea(AreaDto areaDto);
    AreaDto getAreaById(Long area_id);
    List<AreaDto> getAllAreas();
}
