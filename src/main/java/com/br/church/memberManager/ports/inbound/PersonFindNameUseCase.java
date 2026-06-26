package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

import java.util.List;

public interface PersonFindNameUseCase {
    List<PersonResponseDTO> findName(String idOrName);
}
