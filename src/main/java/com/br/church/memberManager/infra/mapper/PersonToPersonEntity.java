package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonEntity {

    public PersonEntity map(Person person){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setBirthDate(person.getBirthDate());
        personEntity.setCpf(person.getCpf());
        personEntity.setEducationEnum(person.getEducationEnum());
        personEntity.setMember(person.isMember());
        personEntity.setMaritalStatusEnum(person.getMaritalStatusEnum());
        personEntity.setNaturalness(person.getNaturalness());
        personEntity.setNickName(person.getNickName());
        personEntity.setName(person.getName());
        personEntity.setOriginCity(person.getOriginCity());
        personEntity.setOrgaoExpeditor(person.getOrgaoExpeditor());
        personEntity.setProfessional(person.getProfessional());
        personEntity.setRg(person.getRg());
        personEntity.setSexyEnum(person.getSexyEnum());
        personEntity.setCompanyWork(person.getCompanyWork());
        personEntity.setDeletedAt(person.getDeletedAt());
        personEntity.setStreet(person.getStreet());
        personEntity.setNumber(person.getNumber());
        personEntity.setComplement(person.getComplement());
        personEntity.setNeighborhood(person.getNeighborhood());
        personEntity.setCity(person.getCity());
        personEntity.setState(person.getState());
        personEntity.setCep(person.getCep());
        return personEntity;
    }

}
