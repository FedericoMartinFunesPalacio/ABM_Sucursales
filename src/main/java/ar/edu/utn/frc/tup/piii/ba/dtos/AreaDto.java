package ar.edu.utn.frc.tup.piii.ba.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaDto {
    @NotBlank
    @NotNull
    private String descripcion;
}
