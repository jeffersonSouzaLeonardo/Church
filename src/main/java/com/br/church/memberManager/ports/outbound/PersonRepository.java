package com.br.church.memberManager.ports.outbound;

import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
