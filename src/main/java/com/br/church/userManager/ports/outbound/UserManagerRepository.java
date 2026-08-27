package com.br.church.userManager.ports.outbound;

import com.br.church.userManager.infra.outbound.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserManagerRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByDeletedAtIsNull();
    Optional<UserEntity> findByIdAndDeletedAtIsNull(Long id);
    List<UserEntity> findByNameContainingIgnoreCaseAndDeletedAtIsNull(String name);
    Optional<UserEntity> findByUsernameAndDeletedAtIsNull(String username);
}
