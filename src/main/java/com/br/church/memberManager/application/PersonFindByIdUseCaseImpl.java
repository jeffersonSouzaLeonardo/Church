package com.br.church.memberManager.application;

import com.br.church.common.NotFoundBusinessException;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonFindByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class PersonFindByIdUseCaseImpl implements PersonFindByIdUseCase {

    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonEntityToPerson personEntityToPerson;
    private final PersonToPersonResponseDTO personToPersonResponseDTO;

    public PersonFindByIdUseCaseImpl(PersonRepositoryAdapter personRepositoryAdapter, PersonEntityToPerson personEntityToPerson, PersonToPersonResponseDTO personToPersonResponseDTO) {
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personEntityToPerson = personEntityToPerson;
        this.personToPersonResponseDTO = personToPersonResponseDTO;
    }

    @Override
    public PersonResponseDTO findById(Long id) {
        PersonEntity personEntity = personRepositoryAdapter.findById(id);
        if (personEntity == null) {
            throw new NotFoundBusinessException("Pessoa não encontrada.");
        }
        return personToPersonResponseDTO.map(personEntityToPerson.map(personEntity));
    }
}
