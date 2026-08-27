package com.br.church.userManager.ports.inbound;

import com.br.church.userManager.infra.inbound.rest.dto.UserRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;

public interface UserCreateUseCase {
    UserResponseDTO create(UserRequestDTO userRequestDTO);
}
