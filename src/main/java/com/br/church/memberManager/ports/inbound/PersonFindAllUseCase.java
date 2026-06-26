package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

import java.util.List;

public interface PersonFindAllUseCase {
    List<PersonResponseDTO> findAll();
}
