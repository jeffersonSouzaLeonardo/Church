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
import com.br.church.userManager.ports.inbound.UserCreateUseCase;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCreateUseCaseImpl implements UserCreateUseCase {

    private final UserRequestDtoToUser userRequestDtoToUser;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserToUserEntity userToUserEntity;
    private final UserToUserResponseDTO userToUserResponseDTO;
    private final UserEntityToUser userEntityToUser;
    private final PasswordEncoder passwordEncoder;

    public UserCreateUseCaseImpl(UserRequestDtoToUser userRequestDtoToUser, UserRepositoryAdapter userRepositoryAdapter, UserToUserEntity userToUserEntity, UserToUserResponseDTO userToUserResponseDTO, UserEntityToUser userEntityToUser, PasswordEncoder passwordEncoder) {
        this.userRequestDtoToUser = userRequestDtoToUser;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userToUserEntity = userToUserEntity;
        this.userToUserResponseDTO = userToUserResponseDTO;
        this.userEntityToUser = userEntityToUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {

        try {
            if (userRepositoryAdapter.findByUsername(userRequestDTO.getUsername()) != null) {
                throw new BusinessException("Username já cadastrado: " + userRequestDTO.getUsername());
            }

            User user = this.userRequestDtoToUser.map(userRequestDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserEntity userEntity = this.userRepositoryAdapter.create(this.userToUserEntity.map(user));
            user = this.userEntityToUser.map(userEntity);
            return this.userToUserResponseDTO.map(user);

        } catch (BusinessException businessException) {
            throw businessException;
        } catch (ConstraintViolationException constraintViolationException) {
            List<String> validationError = constraintViolationException.getConstraintViolations().stream()
                    .map(v -> v.getMessage().toString())
                    .collect(Collectors.toList());
            throw new BusinessException(validationError.toString());
        } catch (Exception e) {
            String username = "";
            if (StringUtils.isNotBlank(userRequestDTO.getUsername())) {
                username = userRequestDTO.getUsername();
            }
            throw new BusinessException("Erro ao salvar usuário " + username, e);
        }

    }

}
