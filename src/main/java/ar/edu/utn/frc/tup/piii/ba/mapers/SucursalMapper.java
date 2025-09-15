package ar.edu.utn.frc.tup.piii.ba.mapers;

import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;
import ar.edu.utn.frc.tup.piii.ba.entities.SucursalEntity;
import java.util.List;
import java.util.stream.Collectors;

public class SucursalMapper {

    public static SucursalDto toSucursalDto(SucursalEntity entity) {
        return SucursalDto.builder()
                .descripcion(entity.getDescripcion())
                .responsableSucursal(entity.getResponsableSucursal())
                .ubicacion(entity.getUbicacion())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .activo(entity.getActivo())
                .areas(entity.getAreas() == null ?
                        List.of() :
                        entity.getAreas()
                                .stream()
                                .map(AreaMapper::toAreaDto)
                                .collect(Collectors.toList()))
                .build();
    }

    public static SucursalEntity toSucursalEntity(SucursalDto dto) {
        return SucursalEntity.builder()
                .descripcion(dto.getDescripcion())
                .responsableSucursal(dto.getResponsableSucursal())
                .ubicacion(dto.getUbicacion())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .activo(dto.getActivo())
                .areas(dto.getAreas() == null ?
                        List.of() :
                        dto.getAreas()
                                .stream()
                                .map(AreaMapper::toAreaEntity)
                                .collect(Collectors.toList()))
                .build();
    }
}
