package com.br.church.userManager.ports.inbound;

import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;

public interface UserFindByIdUseCase {
    UserResponseDTO findById(Long id);
}
