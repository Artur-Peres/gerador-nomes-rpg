package com.rpgapi.gerador_nomes_rpg.controller;

import com.rpgapi.gerador_nomes_rpg.dto.AuthResponseDTO;
import com.rpgapi.gerador_nomes_rpg.dto.LoginRequestDTO;
import com.rpgapi.gerador_nomes_rpg.dto.RegisterRequestDTO;
import com.rpgapi.gerador_nomes_rpg.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody RegisterRequestDTO request){
        AuthResponseDTO response =
                authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody LoginRequestDTO request){
        AuthResponseDTO response =
                authService.login(request);

        return ResponseEntity.ok(response);
    }
}
