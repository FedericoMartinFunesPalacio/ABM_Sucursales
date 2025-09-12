package ar.edu.utn.frc.tup.piii.ba.repositories;

import ar.edu.utn.frc.tup.piii.ba.entities.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {

}
