package com.br.church.userManager.application;

import com.br.church.common.BusinessException;
import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.inbound.rest.dto.UserRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserRequestDtoToUser;
import com.br.church.userManager.infra.mapper.UserToUserEntity;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserUpdateUseCase;
import io.micrometer.common.util.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserUpdateUseCaseImpl implements UserUpdateUseCase {

    private final UserRequestDtoToUser userRequestDtoToUser;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserToUserEntity userToUserEntity;
    private final UserToUserResponseDTO userToUserResponseDTO;
    private final UserEntityToUser userEntityToUser;
    private final PasswordEncoder passwordEncoder;

    public UserUpdateUseCaseImpl(UserRequestDtoToUser userRequestDtoToUser, UserRepositoryAdapter userRepositoryAdapter, UserToUserEntity userToUserEntity, UserToUserResponseDTO userToUserResponseDTO, UserEntityToUser userEntityToUser, PasswordEncoder passwordEncoder) {
        this.userRequestDtoToUser = userRequestDtoToUser;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userToUserEntity = userToUserEntity;
        this.userToUserResponseDTO = userToUserResponseDTO;
        this.userEntityToUser = userEntityToUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        userRequestDTO.setId(id);
        UserEntity currentUserEntity = userRepositoryAdapter.findById(userRequestDTO.getId());
        if (currentUserEntity == null || currentUserEntity.getDeletedAt() != null) {
            throw new BusinessException("Usuário não encontrado para atualização.");
        }

        UserEntity existingUsername = userRepositoryAdapter.findByUsername(userRequestDTO.getUsername());
        if (existingUsername != null && !existingUsername.getId().equals(id)) {
            throw new BusinessException("Username já cadastrado: " + userRequestDTO.getUsername());
        }

        User user = userRequestDtoToUser.map(userRequestDTO);
        UserEntity userEntity = userToUserEntity.map(user);
        userEntity.setCreatedAt(currentUserEntity.getCreatedAt());
        userEntity.setUpdatedAt(LocalDateTime.now());

        if (StringUtils.isNotBlank(userRequestDTO.getPassword())) {
            userEntity.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        } else {
            userEntity.setPassword(currentUserEntity.getPassword());
        }

        UserEntity updatedEntity = userRepositoryAdapter.update(userEntity);
        return userToUserResponseDTO.map(userEntityToUser.map(updatedEntity));
    }
}
