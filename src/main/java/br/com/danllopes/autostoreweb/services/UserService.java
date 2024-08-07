package br.com.danllopes.autostoreweb.services;

import br.com.danllopes.autostoreweb.domain.entities.User;
import br.com.danllopes.autostoreweb.domain.exceptions.DuplicateEmailException;
import br.com.danllopes.autostoreweb.domain.exceptions.LoginAlreadyExistsException;
import br.com.danllopes.autostoreweb.domain.exceptions.UserNotFoundException;
import br.com.danllopes.autostoreweb.dtos.UserRequestDTO;
import br.com.danllopes.autostoreweb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository ;

    public UserService(UserRepository repository) {this.repository = repository;}

    // Devolve todos os usuários em uma lista
    public List<User> getUsers() {return this.repository.findAll();}

    // Devolve usuário com base no ID
    public User getOptionalUser(String id) {return this.findUserById(id);}

    public User createUser(UserRequestDTO data) {
        if (repository.existsByEmail(data.email())) {
            throw new DuplicateEmailException("A user with the same email already exists: " + data.email());
        }

        if (repository.existsByLogin(data.login())) {
            throw new LoginAlreadyExistsException("A user with the same login already exists: " + data.login());
        }

        var newUser = new User(data);
        newUser.encryptPassword(data.password());
        this.repository.save(newUser);
        return newUser;
    }

    public User updateUser(UserRequestDTO data, String id) {
        User user = this.findUserById(id);

        if(this.repository.existsByEmail(data.email()) && !data.email().equals(user.getEmail()))
            throw new DuplicateEmailException("A user with the same email already exists: " + data.email());

        if(this.repository.existsByLogin(data.login()) && !data.login().equals(user.getLogin()))
            throw new LoginAlreadyExistsException("A user with the same login already exists: " + data.login());

        user.setName(data.name());
        user.setEmail(data.email());
        user.setLogin(data.login());
        user.encryptPassword(data.password());

        return user;
    }

    public void removeUser(String id) {
        User user = this.findUserById(id);
        this.repository.delete(user);
    }

    private User findUserById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }
}
