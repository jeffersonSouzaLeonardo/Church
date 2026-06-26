package com.br.church.memberManager.application;

import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonFindAllUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonFindAllUseCaseImpl implements PersonFindAllUseCase {

    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonEntityToPerson personEntityToPerson;
    private final PersonToPersonResponseDTO personToPersonResponseDTO;

    public PersonFindAllUseCaseImpl(PersonRepositoryAdapter personRepositoryAdapter, PersonEntityToPerson personEntityToPerson, PersonToPersonResponseDTO personToPersonResponseDTO) {
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personEntityToPerson = personEntityToPerson;
        this.personToPersonResponseDTO = personToPersonResponseDTO;
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        List<PersonEntity> personEntities = personRepositoryAdapter.findAll();
        List<Person> persons = personEntityToPerson.map(personEntities);
        List<PersonResponseDTO> personResponseDTOs = personToPersonResponseDTO.map(persons);
        return personResponseDTOs;
    }


}
