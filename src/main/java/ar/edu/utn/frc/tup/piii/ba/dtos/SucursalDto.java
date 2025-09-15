package ar.edu.utn.frc.tup.piii.ba.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalDto {
    //ATRIBUTOS QUE LE VOY A MOSTRAR AL USUARio
    @NotBlank
    @NotNull
    private String descripcion;

    @JsonProperty("responsable_sucursal")
    @NotBlank
    @NotNull
    private String responsableSucursal;

    @NotBlank
    @NotNull
    private String ubicacion;

    @NotBlank
    @NotNull
    @Email
    private String correo;

    private String telefono;

    private List<AreaDto> areas;

    private Boolean activo;
}
