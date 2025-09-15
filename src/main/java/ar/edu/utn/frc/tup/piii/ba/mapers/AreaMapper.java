package ar.edu.utn.frc.tup.piii.ba.mapers;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;

public class AreaMapper {

    public static AreaDto toAreaDto(AreaEntity area) {
        return AreaDto.builder()
                .descripcion(area.getDescripcion())
                .build();
    }

    public static AreaEntity toAreaEntity(AreaDto dto) {
        return AreaEntity.builder()
                .descripcion(dto.getDescripcion())
                .build();
    }
}
