package com.br.church.memberManager.infra.outbound.persistence;

import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.outbound.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRepositoryAdapter {
    private final PersonRepository personRepository;

    public PersonRepositoryAdapter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity create(PersonEntity personEntity){
        return this.personRepository.saveAndFlush(personEntity);
    }

    public List<PersonEntity> findAll(){
        return this.personRepository.findAllByDeletedAtIsNull();
    }

    public PersonEntity findById(Long id) {
        return this.personRepository.findByIdAndDeletedAtIsNull(id).orElse(null);
    }

    public List<PersonEntity> findByName(String name) {
        return this.personRepository.findByNameContainingIgnoreCaseAndDeletedAtIsNull(name);
    }

    public PersonEntity update(PersonEntity personEntity) {
        return this.personRepository.saveAndFlush(personEntity);
    }
}
