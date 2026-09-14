package com.br.church.mapper;

import com.br.church.dto.UserRequestDTO;
import com.br.church.dto.UserResponseDTO;
import com.br.church.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserEntity toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstAccess(dto.isFirstAccess());
        entity.setAdministration(dto.isAdministration());
        return entity;
    }

    public UserResponseDTO toResponse(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setFirstAccess(entity.isFirstAccess());
        dto.setAdministration(entity.isAdministration());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public List<UserResponseDTO> toResponse(List<UserEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
