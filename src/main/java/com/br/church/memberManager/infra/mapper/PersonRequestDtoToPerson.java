package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.enums.EducationEnum;
import com.br.church.memberManager.domain.enums.MaritalStatusEnum;
import com.br.church.memberManager.domain.enums.SexyEnum;
import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonRequestDtoToPerson {

    public Person map(PersonRequestDTO personRequestDTO) {
        Person person = new Person();
        person.setId(personRequestDTO.getId());
        person.setName(personRequestDTO.getName());
        person.setNickName(personRequestDTO.getNickName());
        person.setBirthDate(personRequestDTO.getBirthDate());
        person.setNaturalness(personRequestDTO.getNaturalness());
        person.setOriginCity(personRequestDTO.getOriginCity());
        person.setSexyEnum(SexyEnum.valueOf(personRequestDTO.getSexy()));
        person.setMaritalStatus(MaritalStatusEnum.valueOf(personRequestDTO.getMaritalStatus()));
        person.setCpf(personRequestDTO.getCpf());
        person.setRg(personRequestDTO.getRg());
        person.setOrgaoExpeditor(personRequestDTO.getOrgaoExpeditor());
        person.setProfessional(personRequestDTO.getProfessional());
        person.setCompanyWork(personRequestDTO.getCompanyWork());
        person.setEducationEnum(EducationEnum.valueOf(personRequestDTO.getEducation()));
        person.setMember(personRequestDTO.getMember());
        person.setDeletedAt(personRequestDTO.getDeletedAt());
        return person;
    }

}
