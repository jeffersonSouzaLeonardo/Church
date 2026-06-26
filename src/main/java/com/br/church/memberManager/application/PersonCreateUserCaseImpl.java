package com.br.church.memberManager.application;

import com.br.church.common.BusinessException;
import com.br.church.memberManager.domain.model.Person;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonEntityToPersonResponseDTO;
import com.br.church.memberManager.infra.mapper.PersonRequestDtoToPerson;
import com.br.church.memberManager.infra.mapper.PersonToPersonEntity;
import com.br.church.memberManager.infra.outbound.persistence.PersonRepositoryAdapter;
import com.br.church.memberManager.infra.outbound.persistence.entity.PersonEntity;
import com.br.church.memberManager.ports.inbound.PersonCreateUserCase;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonCreateUserCaseImpl implements PersonCreateUserCase {

    private final PersonRequestDtoToPerson personRequestDtoToPerson;
    private final PersonRepositoryAdapter personRepositoryAdapter;
    private final PersonToPersonEntity personToPersonEntity;
    private final PersonEntityToPersonResponseDTO personEntityToPersonResponseDTO;

    public PersonCreateUserCaseImpl(PersonRequestDtoToPerson personRequestDtoToPerson, PersonRepositoryAdapter personRepositoryAdapter, PersonToPersonEntity personToPersonEntity, PersonEntityToPersonResponseDTO personEntityToPersonResponseDTO) {
        this.personRequestDtoToPerson = personRequestDtoToPerson;
        this.personRepositoryAdapter = personRepositoryAdapter;
        this.personToPersonEntity = personToPersonEntity;
        this.personEntityToPersonResponseDTO = personEntityToPersonResponseDTO;
    }

    @Override
    public PersonResponseDTO create(PersonRequestDTO personRequestDTO) {

        try {
            Person person = this.personRequestDtoToPerson.map(personRequestDTO);
            PersonEntity personSaved = this.personRepositoryAdapter.create(this.personToPersonEntity.map(person));
            return this.personEntityToPersonResponseDTO.map(personSaved);

        } catch (ConstraintViolationException constraintViolationException){
            List<String> validationError = constraintViolationException.getConstraintViolations().stream()
                    .map(v -> v.getMessage().toString())
                    .collect(Collectors.toList());
            throw new BusinessException(validationError.toString());
        } catch (Exception e){
            String personName = "";
            if( StringUtils.isNotBlank(personRequestDTO.getName())) {
                personName = personRequestDTO.getName();
            }
            throw new BusinessException("Erro ao salvar pessoa " + personName, e);
        }

    }

}
