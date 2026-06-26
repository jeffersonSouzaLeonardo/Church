package com.br.church.memberManager.application;

import com.br.church.common.BusinessException;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPerson;
import com.br.church.memberManager.infra.mapper.PersonRequestDtoToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonEntity;
import com.br.church.memberManager.infra.mapper.PersonToPersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonUpdateUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonUpdateUseCaseImpl implements PersonUpdateUseCase {

    private final PersonRequestDtoToPerson personRequestDtoToPerson;
    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonToPersonEntity personToPersonEntity;
    private final PersonToPersonResponseDTO personToPersonResponseDTO;
    private final PersonEntityToPerson personEntityToPerson;

    public PersonUpdateUseCaseImpl(PersonRequestDtoToPerson personRequestDtoToPerson, PersonRepositoryAdapter personRepositoryAdapter, PersonToPersonEntity personToPersonEntity, PersonToPersonResponseDTO personToPersonResponseDTO, PersonEntityToPerson personEntityToPerson) {
        this.personRequestDtoToPerson = personRequestDtoToPerson;
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personToPersonEntity = personToPersonEntity;
        this.personToPersonResponseDTO = personToPersonResponseDTO;
        this.personEntityToPerson = personEntityToPerson;
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personRequestDTO) {
        personRequestDTO.setId(id);
        PersonEntity currentPersonEntity = personRepositoryAdapter.findById(personRequestDTO.getId());
        if (currentPersonEntity == null || currentPersonEntity.getDeletedAt() != null) {
            throw new BusinessException("Pessoa não encontrada para atualização.");
        }

        var person = personRequestDtoToPerson.map(personRequestDTO);
        PersonEntity personEntity = personToPersonEntity.map(person);
        personEntity.setUpdatedAt(LocalDateTime.now());

        PersonEntity updatedEntity = personRepositoryAdapter.update(personEntity);
        return personToPersonResponseDTO.map(personEntityToPerson.map(updatedEntity));
    }
}
