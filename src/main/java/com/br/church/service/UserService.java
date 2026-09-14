package com.br.church.service;

import com.br.church.common.BusinessException;
import com.br.church.common.NotFoundBusinessException;
import com.br.church.dto.UserChangePasswordRequestDTO;
import com.br.church.dto.UserRequestDTO;
import com.br.church.dto.UserResponseDTO;
import com.br.church.entity.UserEntity;
import com.br.church.mapper.UserMapper;
import com.br.church.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO create(UserRequestDTO inputDTO) {
        if (userRepository.findByUsernameAndDeletedAtIsNull(inputDTO.getUsername()).isPresent()) {
            throw new BusinessException("Username já cadastrado: " + inputDTO.getUsername());
        }

        UserEntity entity = userMapper.toEntity(inputDTO);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        UserEntity saved = userRepository.saveAndFlush(entity);
        return userMapper.toResponse(saved);
    }

    public List<UserResponseDTO> findAll() {
        return userMapper.toResponse(userRepository.findAllByDeletedAtIsNull());
    }

    public List<UserResponseDTO> findName(String name) {
        return userMapper.toResponse(userRepository.findByNameContainingIgnoreCaseAndDeletedAtIsNull(name));
    }

    public UserResponseDTO findById(Long id) {
        UserEntity entity = userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundBusinessException("Usuário não encontrado."));
        return userMapper.toResponse(entity);
    }

    public UserResponseDTO update(Long id, UserRequestDTO inputDTO) {
        UserEntity current = userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado para atualização."));

        userRepository.findByUsernameAndDeletedAtIsNull(inputDTO.getUsername())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new BusinessException("Username já cadastrado: " + inputDTO.getUsername());
                });

        UserEntity entity = userMapper.toEntity(inputDTO);
        entity.setId(id);
        entity.setCreatedAt(current.getCreatedAt());
        entity.setUpdatedAt(LocalDateTime.now());

        if (StringUtils.isNotBlank(inputDTO.getPassword())) {
            entity.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        } else {
            entity.setPassword(current.getPassword());
        }

        UserEntity updated = userRepository.saveAndFlush(entity);
        return userMapper.toResponse(updated);
    }

    public UserResponseDTO changePassword(Long id, UserChangePasswordRequestDTO inputDTO) {
        UserEntity entity = userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado para alteração de senha."));

        if (!passwordEncoder.matches(inputDTO.getCurrentPassword(), entity.getPassword())) {
            throw new BusinessException("Senha atual inválida.");
        }

        entity.setPassword(passwordEncoder.encode(inputDTO.getNewPassword()));
        entity.setFirstAccess(false);
        entity.setUpdatedAt(LocalDateTime.now());

        UserEntity updated = userRepository.saveAndFlush(entity);
        return userMapper.toResponse(updated);
    }

    public void delete(Long id) {
        UserEntity entity = userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado para exclusão."));

        entity.setDeletedAt(LocalDateTime.now());
        userRepository.saveAndFlush(entity);
    }
}
