package com.br.church.memberManager.application;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonFindNameUseCase;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonFindNameUseCaseImpl implements PersonFindNameUseCase {

    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonEntityToPerson personEntityToPerson;
    private final PersonToPersonResponseDTO personToPersonResponseDTO;

    public PersonFindNameUseCaseImpl(PersonRepositoryAdapter personRepositoryAdapter, PersonEntityToPerson personEntityToPerson, PersonToPersonResponseDTO personToPersonResponseDTO) {
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personEntityToPerson = personEntityToPerson;
        this.personToPersonResponseDTO = personToPersonResponseDTO;
    }

    @Override
    public List<PersonResponseDTO> findName(String name) {
            List<PersonEntity> personEntities = personRepositoryAdapter.findByName(name);
            return personToPersonResponseDTO.map(personEntityToPerson.map(personEntities));
    }
}
