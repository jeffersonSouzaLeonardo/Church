package com.br.church.userManager.infra.mapper;

import com.br.church.userManager.domain.model.User;
import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEntityToUser {

    public User map(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFirstAccess(userEntity.isFirstAccess());
        user.setAdministration(userEntity.isAdministration());
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setUpdatedAt(userEntity.getUpdatedAt());
        user.setDeletedAt(userEntity.getDeletedAt());
        return user;
    }

    public List<User> map(List<UserEntity> userEntities) {
        if (userEntities == null) {
            return null;
        }

        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            users.add(map(userEntity));
        }
        return users;
    }
}
