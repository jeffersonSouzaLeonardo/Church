package com.br.church.memberManager.ports.outbound;

import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findAllByDeletedAtIsNull();
    Optional<PersonEntity> findByIdAndDeletedAtIsNull(Long id);
    List<PersonEntity> findByNameContainingIgnoreCaseAndDeletedAtIsNull(String name);
}
