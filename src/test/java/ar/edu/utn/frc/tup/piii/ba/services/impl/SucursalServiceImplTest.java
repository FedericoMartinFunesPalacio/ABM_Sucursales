package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.dtos.AreaDto;
import ar.edu.utn.frc.tup.piii.ba.dtos.SucursalDto;
import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import ar.edu.utn.frc.tup.piii.ba.entities.SucursalEntity;
import ar.edu.utn.frc.tup.piii.ba.repositories.SucursalRepository;
import org.junit.jupiter.api.BeforeEach;
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
class SucursalServiceImplTest {

    @Mock
    private SucursalRepository sucursalRepository;

    @InjectMocks
    private SucursalServiceImpl sucursalService;

    private SucursalEntity sucursalEntity;
    private SucursalDto sucursalDto;

    @BeforeEach
    void setUp() {
        // DTO válido
        sucursalDto = SucursalDto.builder()
                .descripcion("Sucursal Centro")
                .responsableSucursal("Juan Perez")
                .ubicacion("Av. Siempre Viva 123")
                .correo("sucursal@empresa.com")
                .telefono("123456789")
                .activo(true)
                .areas(List.of(AreaDto.builder().descripcion("Ventas").build()))
                .build();

        // Entity válido
        sucursalEntity = SucursalEntity.builder()
                .id(1L)
                .descripcion("Sucursal Centro")
                .responsableSucursal("Juan Perez")
                .ubicacion("Av. Siempre Viva 123")
                .correo("sucursal@empresa.com")
                .telefono("123456789")
                .activo(true)
                .areas(List.of(AreaEntity.builder().descripcion("Ventas").build()))
                .build();
    }

    // ✅ getSucursales
    @Test
    void getSucursales_returnsList() {
        when(sucursalRepository.findAll()).thenReturn(List.of(sucursalEntity));

        List<SucursalDto> result = sucursalService.getSucursales();

        assertEquals(1, result.size());
        assertEquals("Sucursal Centro", result.get(0).getDescripcion());
        verify(sucursalRepository, times(1)).findAll();
    }

    // ✅ getSucursalByID existente y activo
    @Test
    void getSucursalById_existsAndActive() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursalEntity));

        SucursalDto result = sucursalService.getSucursalByID(1L);

        assertNotNull(result);
        assertEquals("Sucursal Centro", result.getDescripcion());
        verify(sucursalRepository, times(1)).findById(1L);
    }

    // ❌ getSucursalByID inexistente
    @Test
    void getSucursalById_notFound() {
        when(sucursalRepository.findById(99L)).thenReturn(Optional.empty());

        SucursalDto result = sucursalService.getSucursalByID(99L);

        assertNull(result);
    }

    // ❌ getSucursalByID inactiva
    @Test
    void getSucursalById_inactive() {
        sucursalEntity.setActivo(false);
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursalEntity));

        SucursalDto result = sucursalService.getSucursalByID(1L);

        assertNull(result);
    }

    // ✅ createSucursal válido
    @Test
    void createSucursal_valid() {
        when(sucursalRepository.save(any(SucursalEntity.class))).thenReturn(sucursalEntity);
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursalEntity));

        SucursalDto result = sucursalService.createSucursal(sucursalDto);

        assertNotNull(result);
        assertEquals("Sucursal Centro", result.getDescripcion());
        verify(sucursalRepository, times(1)).save(any(SucursalEntity.class));
    }

    // ❌ createSucursal inválido
    @Test
    void createSucursal_invalid() {
        SucursalDto invalidDto = new SucursalDto(); // vacío → falla validación

        SucursalDto result = sucursalService.createSucursal(invalidDto);

        assertNull(result);
        verify(sucursalRepository, never()).save(any(SucursalEntity.class));
    }

    // ✅ updateSucursal válido
    @Test
    void updateSucursal_valid() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursalEntity));
        when(sucursalRepository.save(any(SucursalEntity.class))).thenReturn(sucursalEntity);

        SucursalDto result = sucursalService.updateSucursal(1L, sucursalDto);

        assertNotNull(result);
        assertEquals("Sucursal Centro", result.getDescripcion());
        verify(sucursalRepository, times(1)).save(any(SucursalEntity.class));
    }

    // ❌ updateSucursal inválido
    @Test
    void updateSucursal_invalid() {
        SucursalDto invalidDto = new SucursalDto(); // inválido

        SucursalDto result = sucursalService.updateSucursal(1L, invalidDto);

        assertNull(result);
        verify(sucursalRepository, never()).save(any(SucursalEntity.class));
    }

    // ❌ updateSucursal sucursal no encontrada
    @Test
    void updateSucursal_notFound() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.empty());

        SucursalDto result = sucursalService.updateSucursal(1L, sucursalDto);

        assertNull(result);
    }

    // ✅ deleteSucursal existente
    @Test
    void deleteSucursal_existing() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursalEntity));

        sucursalService.deleteSucursal(1L);

        assertFalse(sucursalEntity.getActivo()); // marcado como inactivo
        verify(sucursalRepository, times(1)).save(sucursalEntity);
    }

    // ❌ deleteSucursal inexistente
    @Test
    void deleteSucursal_notFound() {
        when(sucursalRepository.findById(1L)).thenReturn(Optional.empty());

        sucursalService.deleteSucursal(1L);

        verify(sucursalRepository, never()).save(any(SucursalEntity.class));
    }
}