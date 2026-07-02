package com.rpgapi.gerador_nomes_rpg.dto;

import lombok.Getter;

@Getter
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
}
