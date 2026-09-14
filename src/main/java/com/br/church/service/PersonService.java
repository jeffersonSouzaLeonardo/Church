package com.br.church.service;

import com.br.church.common.BusinessException;
import com.br.church.common.NotFoundBusinessException;
import com.br.church.dto.PersonRequestDTO;
import com.br.church.dto.PersonResponseDTO;
import com.br.church.entity.PersonEntity;
import com.br.church.mapper.PersonMapper;
import com.br.church.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonResponseDTO create(PersonRequestDTO inputDTO) {
        PersonEntity saved = personRepository.saveAndFlush(personMapper.toEntity(inputDTO));
        return personMapper.toResponse(saved);
    }

    public List<PersonResponseDTO> findAll() {
        return personMapper.toResponse(personRepository.findAllByDeletedAtIsNull());
    }

    public PersonResponseDTO findById(Long id) {
        PersonEntity entity = personRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new NotFoundBusinessException("Pessoa não encontrada."));
        return personMapper.toResponse(entity);
    }

    public List<PersonResponseDTO> findName(String name) {
        return personMapper.toResponse(personRepository.findByNameContainingIgnoreCaseAndDeletedAtIsNull(name));
    }

    public PersonResponseDTO update(Long id, PersonRequestDTO inputDTO) {
        PersonEntity current = personRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new BusinessException("Pessoa não encontrada para atualização."));

        PersonEntity entity = personMapper.toEntity(inputDTO);
        entity.setId(id);
        entity.setCreatedAt(current.getCreatedAt());
        entity.setUpdatedAt(LocalDateTime.now());

        PersonEntity updated = personRepository.saveAndFlush(entity);
        return personMapper.toResponse(updated);
    }

    public void delete(Long id) {
        PersonEntity entity = personRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new BusinessException("Pessoa não encontrada para exclusão."));

        entity.setDeletedAt(LocalDateTime.now());
        personRepository.saveAndFlush(entity);
    }
}
