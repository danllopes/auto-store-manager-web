package br.com.danllopes.autostoreweb.repositories;

import br.com.danllopes.autostoreweb.domain.entities.Motorcycle;
import br.com.danllopes.autostoreweb.domain.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, String> {
    List<Motorcycle> findByStatus(VehicleStatus status);
}
