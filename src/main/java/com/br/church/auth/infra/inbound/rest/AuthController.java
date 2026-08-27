package com.br.church.auth.infra.inbound.rest;

import com.br.church.auth.infra.inbound.rest.dto.AuthRequestDTO;
import com.br.church.auth.infra.inbound.rest.dto.AuthResponseDTO;
import com.br.church.auth.infra.security.JwtUtil;
import com.br.church.auth.ports.outbound.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtil.generateToken(request.getUsername());

        var user = userRepository.findByUsernameAndDeletedAtIsNull(request.getUsername());
        return ResponseEntity.ok(new AuthResponseDTO(user.get().getId(), token, user.get().isAdministration()));
    }
}
