package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonEntityToPerson {

    public Person map(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }

        Person person = new Person();
        person.setId(personEntity.getId());
        person.setBirthDate(personEntity.getBirthDate());
        person.setCpf(personEntity.getCpf());
        person.setEducationEnum(personEntity.getEducationEnum());
        person.setMember(personEntity.isMember());
        person.setMaritalStatusEnum(personEntity.getMaritalStatusEnum());
        person.setNaturalness(personEntity.getNaturalness());
        person.setNickName(personEntity.getNickName());
        person.setName(personEntity.getName());
        person.setOriginCity(personEntity.getOriginCity());
        person.setOrgaoExpeditor(personEntity.getOrgaoExpeditor());
        person.setProfessional(personEntity.getProfessional());
        person.setRg(personEntity.getRg());
        person.setSexyEnum(personEntity.getSexyEnum());
        person.setCompanyWork(personEntity.getCompanyWork());
        person.setDeletedAt(personEntity.getDeletedAt());
        return person;
    }

    public List<Person> map(List<PersonEntity> personEntities) {
        if (personEntities == null) {
            return null;
        }

        List<Person> persons = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            persons.add(map(personEntity));
        }
        return persons;
    }
}
