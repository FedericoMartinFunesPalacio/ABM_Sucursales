package ar.edu.utn.frc.tup.piii.ba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
/*
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne //MUCHOS MATCHS VAN A TENER UN USER
    private DummyEntity user;

    @Enumerated(EnumType.STRING) //PARA LOS ENUNMS
    private String difficulty; //SON ENUMS

    private Integer number;

    private Integer tries;

    @Enumerated(EnumType.STRING) //PARA LOS ENUNMS
    private String status;//SON ENUMS

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
 */