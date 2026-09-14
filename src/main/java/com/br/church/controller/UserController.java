package com.br.church.controller;

import com.br.church.dto.UserChangePasswordRequestDTO;
import com.br.church.dto.UserRequestDTO;
import com.br.church.dto.UserResponseDTO;
import com.br.church.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO inputDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(inputDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<UserResponseDTO>> findName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findName(name));
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @Valid @RequestBody UserRequestDTO inputDTO) {
        return ResponseEntity.ok(userService.update(id, inputDTO));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UserResponseDTO> changePassword(@PathVariable Long id, @Valid @RequestBody UserChangePasswordRequestDTO inputDTO) {
        return ResponseEntity.ok(userService.changePassword(id, inputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
