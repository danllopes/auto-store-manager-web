package br.com.danllopes.autostoreweb.controller;

import br.com.danllopes.autostoreweb.domain.entities.User;
import br.com.danllopes.autostoreweb.dtos.UserRequestDTO;
import br.com.danllopes.autostoreweb.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {this.service = service;}

    @PostMapping("/register")
    @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário com os dados fornecidos.", tags = "Usuário")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRequestDTO data) {
        return new ResponseEntity<>(this.service.createUser(data), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.", tags = "Usuário")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(this.service.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário específico com base no ID fornecido.", tags = "Usuário")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        return new ResponseEntity<>(this.service.getOptionalUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    @Transactional
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente com base no ID fornecido.", tags = "Usuário")
    public ResponseEntity<User> updateStudent(@PathVariable String userId, @RequestBody @Valid UserRequestDTO data) {
        return new ResponseEntity<>(this.service.updateUser(data, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @Transactional
    @Operation(summary = "Excluir usuário", description = "Exclui um usuário com base no ID fornecido.", tags = "Usuário")
    public ResponseEntity<Void> deleteStudent(@PathVariable String userId) {
        this.service.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
