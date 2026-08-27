package com.br.church.userManager.ports.inbound;

import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;

public interface UserDeleteUseCase {
    UserResponseDTO delete(Long id);
}
