package com.br.church.userManager.infra.mapper;

import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.inbound.rest.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserResponseDTO {

    public UserResponseDTO map(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setFirstAccess(user.isFirstAccess());
        userResponseDTO.setAdministration(user.isAdministration());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setUpdatedAt(user.getUpdatedAt());
        return userResponseDTO;
    }

    public List<UserResponseDTO> map(List<User> users) {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for (User user : users) {
            userResponseDTOS.add(map(user));
        }
        return userResponseDTOS;
    }
}
