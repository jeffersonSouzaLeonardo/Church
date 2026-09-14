package com.br.church.service;

import com.br.church.dto.AuthRequestDTO;
import com.br.church.dto.AuthResponseDTO;
import com.br.church.infra.security.JwtUtil;
import com.br.church.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                       UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtil.generateToken(request.getUsername());

        var user = userRepository.findByUsernameAndDeletedAtIsNull(request.getUsername());
        return new AuthResponseDTO(user.get().getId(), token, user.get().isAdministration());
    }
}
