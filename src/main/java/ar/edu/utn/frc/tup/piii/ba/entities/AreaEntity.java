package ar.edu.utn.frc.tup.piii.ba.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "areas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "areas")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    //@Column(name = "tareas",nullable = false) //HACEMOS UNA RELACION CON TAREAS?
    //private String tareas;
}
