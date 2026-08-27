package com.br.church.userManager.infra.outbound.persistence;

import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import com.br.church.userManager.ports.outbound.UserManagerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryAdapter {

    private final UserManagerRepository userRepository;

    public UserRepositoryAdapter(UserManagerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity) {
        return this.userRepository.saveAndFlush(userEntity);
    }

    public List<UserEntity> findAll() {
        return this.userRepository.findAllByDeletedAtIsNull();
    }

    public UserEntity findById(Long id) {
        return this.userRepository.findByIdAndDeletedAtIsNull(id).orElse(null);
    }

    public List<UserEntity> findByName(String name) {
        return this.userRepository.findByNameContainingIgnoreCaseAndDeletedAtIsNull(name);
    }

    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsernameAndDeletedAtIsNull(username).orElse(null);
    }

    public UserEntity update(UserEntity userEntity) {
        return this.userRepository.saveAndFlush(userEntity);
    }
}
