package com.br.church.userManager.infra.mapper;

import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntity {

    public UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstAccess(user.isFirstAccess());
        userEntity.setAdministration(user.isAdministration());
        userEntity.setCreatedAt(user.getCreatedAt());
        userEntity.setUpdatedAt(user.getUpdatedAt());
        userEntity.setDeletedAt(user.getDeletedAt());
        return userEntity;
    }
}
