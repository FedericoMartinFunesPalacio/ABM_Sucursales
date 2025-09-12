package ar.edu.utn.frc.tup.piii.ba.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DummyDto {
    //ATRIBUTOS QUE LE VOY A MOSTRAR AL USUARio
    private Long id;
    @JsonProperty("username")
    private String userName;
    @Email
    private String email;
}
