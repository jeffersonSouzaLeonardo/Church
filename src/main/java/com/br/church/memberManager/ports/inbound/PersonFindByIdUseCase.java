package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

public interface PersonFindByIdUseCase {
    PersonResponseDTO findById(Long id);
}
