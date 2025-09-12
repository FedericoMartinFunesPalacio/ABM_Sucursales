package ar.edu.utn.frc.tup.piii.ba.repositories;

import ar.edu.utn.frc.tup.piii.ba.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
}
