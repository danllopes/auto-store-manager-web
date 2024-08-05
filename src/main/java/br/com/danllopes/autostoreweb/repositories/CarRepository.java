package br.com.danllopes.autostoreweb.repositories;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import br.com.danllopes.autostoreweb.domain.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findByStatus(VehicleStatus status);
}
