package com.br.church.userManager.ports.inbound;

import com.br.church.userManager.infra.inbound.rest.dto.UserChangePasswordRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;

public interface UserChangePasswordUseCase {
    UserResponseDTO changePassword(Long id, UserChangePasswordRequestDTO userChangePasswordRequestDTO);
}
