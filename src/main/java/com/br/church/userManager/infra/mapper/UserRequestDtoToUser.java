package com.br.church.userManager.infra.mapper;

import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.inbound.rest.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoToUser {

    public User map(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setFirstAccess(userRequestDTO.isFirstAccess());
        user.setAdministration(userRequestDTO.isAdministration());
        return user;
    }
}
