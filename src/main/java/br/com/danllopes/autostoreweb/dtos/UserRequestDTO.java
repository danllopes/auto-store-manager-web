package br.com.danllopes.autostoreweb.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

        @NotBlank
        String name,

        @NotBlank
        @Email(message = "Invalid Email")
        String email,

        @NotBlank
        String login,

        @NotBlank
        String password
) {
}
