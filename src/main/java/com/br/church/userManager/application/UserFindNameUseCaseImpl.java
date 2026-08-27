package com.br.church.userManager.application;

import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserFindNameUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFindNameUseCaseImpl implements UserFindNameUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserEntityToUser userEntityToUser;
    private final UserToUserResponseDTO userToUserResponseDTO;

    public UserFindNameUseCaseImpl(UserRepositoryAdapter userRepositoryAdapter, UserEntityToUser userEntityToUser, UserToUserResponseDTO userToUserResponseDTO) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userEntityToUser = userEntityToUser;
        this.userToUserResponseDTO = userToUserResponseDTO;
    }

    @Override
    public List<UserResponseDTO> findName(String name) {
        List<UserEntity> userEntities = userRepositoryAdapter.findByName(name);
        return userToUserResponseDTO.map(userEntityToUser.map(userEntities));
    }
}
