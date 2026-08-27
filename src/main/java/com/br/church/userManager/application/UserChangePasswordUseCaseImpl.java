package com.br.church.userManager.application;

import com.br.church.common.BusinessException;
import com.br.church.userManager.infra.inbound.rest.dto.UserChangePasswordRequestDTO;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import com.br.church.userManager.infra.mapper.UserEntityToUser;
import com.br.church.userManager.infra.mapper.UserToUserResponseDTO;
import com.br.church.userManager.infra.outbound.persistence.UserRepositoryAdapter;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.inbound.UserChangePasswordUseCase;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserChangePasswordUseCaseImpl implements UserChangePasswordUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserEntityToUser userEntityToUser;
    private final UserToUserResponseDTO userToUserResponseDTO;
    private final PasswordEncoder passwordEncoder;

    public UserChangePasswordUseCaseImpl(UserRepositoryAdapter userRepositoryAdapter, UserEntityToUser userEntityToUser, UserToUserResponseDTO userToUserResponseDTO, PasswordEncoder passwordEncoder) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userEntityToUser = userEntityToUser;
        this.userToUserResponseDTO = userToUserResponseDTO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO changePassword(Long id, UserChangePasswordRequestDTO userChangePasswordRequestDTO) {
        UserEntity userEntity = userRepositoryAdapter.findById(id);
        if (userEntity == null || userEntity.getDeletedAt() != null) {
            throw new BusinessException("Usuário não encontrado para alteração de senha.");
        }

        if (!passwordEncoder.matches(userChangePasswordRequestDTO.getCurrentPassword(), userEntity.getPassword())) {
            throw new BusinessException("Senha atual inválida.");
        }

        userEntity.setPassword(passwordEncoder.encode(userChangePasswordRequestDTO.getNewPassword()));
        userEntity.setFirstAccess(false);
        userEntity.setUpdatedAt(LocalDateTime.now());

        UserEntity updatedEntity = userRepositoryAdapter.update(userEntity);
        return userToUserResponseDTO.map(userEntityToUser.map(updatedEntity));
    }
}
