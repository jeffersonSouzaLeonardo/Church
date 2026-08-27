package com.br.church.userManager.application;

import com.br.church.common.BusinessException;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserDeleteUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDeleteUseCaseImpl implements UserDeleteUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserEntityToUser userEntityToUser;
    private final UserToUserResponseDTO userToUserResponseDTO;

    public UserDeleteUseCaseImpl(UserRepositoryAdapter userRepositoryAdapter, UserEntityToUser userEntityToUser, UserToUserResponseDTO userToUserResponseDTO) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userEntityToUser = userEntityToUser;
        this.userToUserResponseDTO = userToUserResponseDTO;
    }

    @Override
    public UserResponseDTO delete(Long id) {
        UserEntity userEntity = userRepositoryAdapter.findById(id);
        if (userEntity == null || userEntity.getDeletedAt() != null) {
            throw new BusinessException("Usuário não encontrado para exclusão.");
        }

        userEntity.setDeletedAt(LocalDateTime.now());
        UserEntity savedEntity = userRepositoryAdapter.update(userEntity);
        return userToUserResponseDTO.map(userEntityToUser.map(savedEntity));
    }
}
