package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonToPersonResponseDTO {

    public PersonResponseDTO map(Person person) {
        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setId(person.getId());
        personResponseDTO.setName(person.getName());
        personResponseDTO.setNickName(person.getNickName());
        personResponseDTO.setBirthDate(person.getBirthDate());
        personResponseDTO.setNaturalness(person.getNaturalness());
        personResponseDTO.setOriginCity(person.getOriginCity());
        personResponseDTO.setSexy(person.getSexyEnum() != null ? person.getSexyEnum().name() : null);
        personResponseDTO.setMaritalStatus(person.getMaritalStatusEnum() != null ? person.getMaritalStatusEnum().name() : null);
        personResponseDTO.setCpf(person.getCpf());
        personResponseDTO.setRg(person.getRg());
        personResponseDTO.setOrgaoExpeditor(person.getOrgaoExpeditor());
        personResponseDTO.setProfessional(person.getProfessional());
        personResponseDTO.setCompanyWork(person.getCompanyWork());
        personResponseDTO.setEducation(person.getEducationEnum() != null ? person.getEducationEnum().name() : null);
        personResponseDTO.setMember(person.isMember() ? "yes" : "No");
        personResponseDTO.setDeletedAt(person.getDeletedAt());
        personResponseDTO.setStreet(person.getStreet());
        personResponseDTO.setNumber(person.getNumber());
        personResponseDTO.setComplement(person.getComplement());
        personResponseDTO.setNeighborhood(person.getNeighborhood());
        personResponseDTO.setCity(person.getCity());
        personResponseDTO.setState(person.getState());
        personResponseDTO.setCep(person.getCep());
        return personResponseDTO;
    }

    public List<PersonResponseDTO> map(List<Person> persons) {
        List<PersonResponseDTO> personResponseDTOS = new ArrayList<>();
        for (Person person : persons) {
            personResponseDTOS.add(map(person));
        }
        return personResponseDTOS;
    }
}
