package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.repositories.AreaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AreaServiceImplTest {

    @Mock
    private AreaRepository areaRepository;

    @InjectMocks
    private AreaServiceImpl areaService;

    @Test
    void createArea() {
        // Arrange
        AreaDto dto = new AreaDto("Área de Ventas");
        AreaEntity entity = new AreaEntity();
        entity.setDescripcion("Área de Ventas");

        AreaEntity savedEntity = new AreaEntity();
        savedEntity.setDescripcion("Área de Ventas");

        when(areaRepository.save(any(AreaEntity.class))).thenReturn(savedEntity);

        // Act
        AreaDto result = areaService.createArea(dto);

        // Assert
        assertNotNull(result);
        assertEquals("Área de Ventas", result.getDescripcion());
        verify(areaRepository, times(1)).save(any(AreaEntity.class));
    }

    @Test
    void getAreaById_found() {
        // Arrange
        AreaEntity entity = new AreaEntity();
        entity.setDescripcion("Área de Finanzas");

        when(areaRepository.findById(1L)).thenReturn(Optional.of(entity));

        // Act
        AreaDto result = areaService.getAreaById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Área de Finanzas", result.getDescripcion());
        verify(areaRepository, times(1)).findById(1L);
    }

    @Test
    void getAreaById_notFound() {
        // Arrange
        when(areaRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        AreaDto result = areaService.getAreaById(99L);

        // Assert
        assertNull(result);
        verify(areaRepository, times(1)).findById(99L);
    }

    @Test
    void getAllAreas() {
        // Arrange
        AreaEntity entity1 = new AreaEntity();
        entity1.setDescripcion("Área de IT");

        AreaEntity entity2 = new AreaEntity();
        entity2.setDescripcion("Área de RRHH");

        when(areaRepository.findAll()).thenReturn(List.of(entity1, entity2));

        // Act
        List<AreaDto> result = areaService.getAllAreas();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Área de IT", result.get(0).getDescripcion());
        assertEquals("Área de RRHH", result.get(1).getDescripcion());
        verify(areaRepository, times(1)).findAll();
    }
}