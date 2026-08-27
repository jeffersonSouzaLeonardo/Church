package com.br.church.userManager.infra.inbound.rest;

import com.br.church.userManager.infra.inbound.rest.dto.UserChangePasswordRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.ports.inbound.UserChangePasswordUseCase;
import com.br.church.userManager.ports.inbound.UserCreateUseCase;
import com.br.church.userManager.ports.inbound.UserDeleteUseCase;
import com.br.church.userManager.ports.inbound.UserFindAllUseCase;
import com.br.church.userManager.ports.inbound.UserFindByIdUseCase;
import com.br.church.userManager.ports.inbound.UserFindNameUseCase;
import com.br.church.userManager.ports.inbound.UserUpdateUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserCreateUseCase userCreateUseCase;
    private final UserFindAllUseCase userFindAllUseCase;
    private final UserDeleteUseCase userDeleteUseCase;
    private final UserFindNameUseCase userFindNameUseCase;
    private final UserFindByIdUseCase userFindByIdUseCase;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserChangePasswordUseCase userChangePasswordUseCase;

    public UserController(UserCreateUseCase userCreateUseCase, UserFindAllUseCase userFindAllUseCase,
                          UserDeleteUseCase userDeleteUseCase, UserFindNameUseCase userFindNameUseCase,
                          UserFindByIdUseCase userFindByIdUseCase, UserUpdateUseCase userUpdateUseCase,
                          UserChangePasswordUseCase userChangePasswordUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userFindAllUseCase = userFindAllUseCase;
        this.userDeleteUseCase = userDeleteUseCase;
        this.userFindNameUseCase = userFindNameUseCase;
        this.userFindByIdUseCase = userFindByIdUseCase;
        this.userUpdateUseCase = userUpdateUseCase;
        this.userChangePasswordUseCase = userChangePasswordUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO inputDTO) {
        UserResponseDTO userResponseDTO = userCreateUseCase.create(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(userFindAllUseCase.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<UserResponseDTO>> findName(@PathVariable String name) {
        return ResponseEntity.ok(userFindNameUseCase.findName(name));
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userFindByIdUseCase.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @Valid @RequestBody UserRequestDTO inputDTO) {
        return ResponseEntity.ok(userUpdateUseCase.update(id, inputDTO));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UserResponseDTO> changePassword(@PathVariable Long id, @Valid @RequestBody UserChangePasswordRequestDTO inputDTO) {
        return ResponseEntity.ok(userChangePasswordUseCase.changePassword(id, inputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userDeleteUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
