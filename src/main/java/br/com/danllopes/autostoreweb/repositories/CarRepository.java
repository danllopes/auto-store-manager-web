package br.com.danllopes.autostoreweb.repositories;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
