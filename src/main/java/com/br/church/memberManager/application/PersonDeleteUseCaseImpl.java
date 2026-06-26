package com.br.church.memberManager.application;

import com.br.church.common.BusinessException;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonDeleteUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonDeleteUseCaseImpl implements PersonDeleteUseCase {

    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonEntityToPerson personEntityToPerson;
    private final PersonToPersonResponseDTO personToPersonResponseDTO;

    public PersonDeleteUseCaseImpl(PersonRepositoryAdapter personRepositoryAdapter, PersonEntityToPerson personEntityToPerson, PersonToPersonResponseDTO personToPersonResponseDTO) {
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personEntityToPerson = personEntityToPerson;
        this.personToPersonResponseDTO = personToPersonResponseDTO;
    }

    @Override
    public PersonResponseDTO delete(Long id) {
        PersonEntity personEntity = personRepositoryAdapter.findById(id);
        if (personEntity == null || personEntity.getDeletedAt() != null) {
            throw new BusinessException("Pessoa não encontrada para exclusão.");
        }

        personEntity.setDeletedAt(LocalDateTime.now());
        PersonEntity savedEntity = personRepositoryAdapter.update(personEntity);
        return personToPersonResponseDTO.map(personEntityToPerson.map(savedEntity));
    }
}
