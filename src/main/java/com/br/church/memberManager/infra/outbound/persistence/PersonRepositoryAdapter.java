package com.br.church.memberManager.infra.outbound.persistence;

import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.outbound.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonRepositoryAdapter {
    private final PersonRepository personRepository;

    public PersonRepositoryAdapter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity create(PersonEntity personEntity){
        return this.personRepository.saveAndFlush(personEntity);
    }

}
