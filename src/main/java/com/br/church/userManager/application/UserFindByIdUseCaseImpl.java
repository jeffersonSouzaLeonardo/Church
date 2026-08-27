package com.br.church.userManager.application;

import com.br.church.common.NotFoundBusinessException;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserFindByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class UserFindByIdUseCaseImpl implements UserFindByIdUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserEntityToUser userEntityToUser;
    private final UserToUserResponseDTO userToUserResponseDTO;

    public UserFindByIdUseCaseImpl(UserRepositoryAdapter userRepositoryAdapter, UserEntityToUser userEntityToUser, UserToUserResponseDTO userToUserResponseDTO) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userEntityToUser = userEntityToUser;
        this.userToUserResponseDTO = userToUserResponseDTO;
    }

    @Override
    public UserResponseDTO findById(Long id) {
        UserEntity userEntity = userRepositoryAdapter.findById(id);
        if (userEntity == null) {
            throw new NotFoundBusinessException("Usuário não encontrado.");
        }
        return userToUserResponseDTO.map(userEntityToUser.map(userEntity));
    }
}
