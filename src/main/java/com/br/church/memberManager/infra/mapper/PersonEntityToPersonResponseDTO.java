package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToPersonResponseDTO {

    public PersonResponseDTO map(PersonEntity personEntity) {
        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setId(personEntity.getId());
        personResponseDTO.setName(personEntity.getName());
        personResponseDTO.setNickName(personEntity.getNickName());
        personResponseDTO.setBirthDate(personEntity.getBirthDate());
        personResponseDTO.setNaturalness(personEntity.getNaturalness());
        personResponseDTO.setOriginCity(personEntity.getOriginCity());
        personResponseDTO.setSexy(personEntity.getSexyEnum().name());
        personResponseDTO.setMaritalStatus(personEntity.getMaritalStatusEnum().name());
        personResponseDTO.setCpf(personEntity.getCpf());
        personResponseDTO.setRg(personEntity.getRg());
        personResponseDTO.setOrgaoExpeditor(personEntity.getOrgaoExpeditor());
        personResponseDTO.setProfessional(personEntity.getProfessional());
        personResponseDTO.setCompanyWork(personEntity.getCompanyWork());
        personResponseDTO.setEducation(personEntity.getEducationEnum().name());
        personResponseDTO.setMember(personEntity.isMember() ? "yes" : "No");
        personResponseDTO.setDeletedAt(personEntity.getDeletedAt());
        return personResponseDTO;
    }
}
