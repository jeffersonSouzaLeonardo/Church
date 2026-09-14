package com.br.church.mapper;

import com.br.church.dto.PersonRequestDTO;
import com.br.church.dto.PersonResponseDTO;
import com.br.church.entity.PersonEntity;
import com.br.church.model.enums.EducationEnum;
import com.br.church.model.enums.MaritalStatusEnum;
import com.br.church.model.enums.ReceptionMethodEnum;
import com.br.church.model.enums.SexyEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public PersonEntity toEntity(PersonRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        PersonEntity entity = new PersonEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNickName(dto.getNickName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setNaturalness(dto.getNaturalness());
        entity.setOriginCity(dto.getOriginCity());
        entity.setSexyEnum(SexyEnum.fromString(dto.getSexy()));
        entity.setMaritalStatusEnum(MaritalStatusEnum.fromString(dto.getMaritalStatus()));
        entity.setCpf(dto.getCpf());
        entity.setRg(dto.getRg());
        entity.setOrgaoExpeditor(dto.getOrgaoExpeditor());
        entity.setProfessional(dto.getProfessional());
        entity.setCompanyWork(dto.getCompanyWork());
        entity.setEducationEnum(EducationEnum.fromString(dto.getEducation()));
        entity.setMember(dto.getMember());
        entity.setDeletedAt(dto.getDeletedAt());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCep(dto.getCep());
        entity.setConversionDate(dto.getConversionDate());
        entity.setConversionPlace(dto.getConversionPlace());
        entity.setBaptismPlace(dto.getBaptismPlace());
        entity.setBaptizedBy(dto.getBaptizedBy());
        entity.setDiscipleship(dto.isDiscipleship());
        entity.setBibleSchool(dto.isBibleSchool());
        entity.setLastChurchName(dto.getLastChurchName());
        entity.setDenomination(dto.getDenomination());
        entity.setChurchCity(dto.getChurchCity());
        entity.setMembershipYears(dto.getMembershipYears());
        entity.setReceptionMethod(ReceptionMethodEnum.fromString(dto.getReceptionMethod()));
        entity.setReceptionDate(dto.getReceptionDate());
        entity.setMembersBookNumber(dto.getMembersBookNumber());
        entity.setSpecialNeeds(dto.getSpecialNeeds());
        entity.setLastPastoralVisit(dto.getLastPastoralVisit());
        entity.setCellGroup(dto.isCellGroup());
        entity.setCellGroupName(dto.getCellGroupName());
        entity.setCellGroupLeaderName(dto.getCellGroupLeaderName());
        return entity;
    }

    public PersonResponseDTO toResponse(PersonEntity entity) {
        if (entity == null) {
            return null;
        }
        PersonResponseDTO dto = new PersonResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNickName(entity.getNickName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setNaturalness(entity.getNaturalness());
        dto.setOriginCity(entity.getOriginCity());
        dto.setSexy(entity.getSexyEnum() != null ? entity.getSexyEnum().name() : null);
        dto.setMaritalStatus(entity.getMaritalStatusEnum() != null ? entity.getMaritalStatusEnum().name() : null);
        dto.setCpf(entity.getCpf());
        dto.setRg(entity.getRg());
        dto.setOrgaoExpeditor(entity.getOrgaoExpeditor());
        dto.setProfessional(entity.getProfessional());
        dto.setCompanyWork(entity.getCompanyWork());
        dto.setEducation(entity.getEducationEnum() != null ? entity.getEducationEnum().name() : null);
        dto.setMember(entity.isMember() ? "yes" : "No");
        dto.setDeletedAt(entity.getDeletedAt());
        dto.setStreet(entity.getStreet());
        dto.setNumber(entity.getNumber());
        dto.setComplement(entity.getComplement());
        dto.setNeighborhood(entity.getNeighborhood());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setCep(entity.getCep());
        dto.setConversionDate(entity.getConversionDate());
        dto.setConversionPlace(entity.getConversionPlace());
        dto.setBaptismPlace(entity.getBaptismPlace());
        dto.setBaptizedBy(entity.getBaptizedBy());
        dto.setDiscipleship(entity.isDiscipleship() ? "yes" : "No");
        dto.setBibleSchool(entity.isBibleSchool() ? "yes" : "No");
        dto.setLastChurchName(entity.getLastChurchName());
        dto.setDenomination(entity.getDenomination());
        dto.setChurchCity(entity.getChurchCity());
        dto.setMembershipYears(entity.getMembershipYears());
        dto.setReceptionMethod(entity.getReceptionMethod() != null ? entity.getReceptionMethod().name() : null);
        dto.setReceptionDate(entity.getReceptionDate());
        dto.setMembersBookNumber(entity.getMembersBookNumber());
        dto.setSpecialNeeds(entity.getSpecialNeeds());
        dto.setLastPastoralVisit(entity.getLastPastoralVisit());
        dto.setCellGroup(entity.isCellGroup() ? "yes" : "No");
        dto.setCellGroupName(entity.getCellGroupName());
        dto.setCellGroupLeaderName(entity.getCellGroupLeaderName());
        return dto;
    }

    public List<PersonResponseDTO> toResponse(List<PersonEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
