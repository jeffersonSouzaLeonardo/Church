package com.br.church.userManager.application;

import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserFindAllUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFindAllUseCaseImpl implements UserFindAllUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserEntityToUser userEntityToUser;
    private final UserToUserResponseDTO userToUserResponseDTO;

    public UserFindAllUseCaseImpl(UserRepositoryAdapter userRepositoryAdapter, UserEntityToUser userEntityToUser, UserToUserResponseDTO userToUserResponseDTO) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userEntityToUser = userEntityToUser;
        this.userToUserResponseDTO = userToUserResponseDTO;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<UserEntity> userEntities = userRepositoryAdapter.findAll();
        List<User> users = userEntityToUser.map(userEntities);
        return userToUserResponseDTO.map(users);
    }
}
