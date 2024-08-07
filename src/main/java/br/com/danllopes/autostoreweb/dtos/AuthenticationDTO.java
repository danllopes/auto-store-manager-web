package br.com.danllopes.autostoreweb.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        @NotBlank
        String login,

        @NotBlank
        String password
) {
}
