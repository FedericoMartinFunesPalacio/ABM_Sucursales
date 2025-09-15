package ar.edu.utn.frc.tup.piii.ba.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "sucursales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "sucursales") //VERIFICAR LOS ATRIBUTOS DE LA ENTIDAD
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "responsable_sucursal",nullable = false) //HACEMOS UNA RELACION CON USUARIOS?
    private String responsableSucursal;

    @Column(name = "ubicacion",nullable = false)
    private String ubicacion;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "telefono",nullable = true) //POSIBLE TELEFONO
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL) //UNA SUCURSAL TIENE VARIAS AREAS, PERO UN AREA PERTENECE A UNA SOLA SUCURSAL
    private List<AreaEntity> areas;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    //@Column(name = "empleados",nullable = false)
    //private String empleados; //VER SI HACEMOS UNA RELACION CON EMPLEADOS
}
