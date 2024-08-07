package br.com.danllopes.autostoreweb.repositories;

import br.com.danllopes.autostoreweb.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
}
