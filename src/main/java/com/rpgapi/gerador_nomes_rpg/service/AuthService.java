package com.rpgapi.gerador_nomes_rpg.service;

import com.rpgapi.gerador_nomes_rpg.dto.AuthResponseDTO;
import com.rpgapi.gerador_nomes_rpg.dto.LoginRequestDTO;
import com.rpgapi.gerador_nomes_rpg.dto.RegisterRequestDTO;
import com.rpgapi.gerador_nomes_rpg.model.User;
import com.rpgapi.gerador_nomes_rpg.repository.UserRepository;
import com.rpgapi.gerador_nomes_rpg.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO register(RegisterRequestDTO request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email já cadastrado!");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(savedUser);

        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO login(LoginRequestDTO request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        boolean senhaCorreta = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(!senhaCorreta) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(token);
    }


}
