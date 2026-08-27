package com.br.church.userManager.ports.inbound;

import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;

import java.util.List;

public interface UserFindAllUseCase {
    List<UserResponseDTO> findAll();
}
