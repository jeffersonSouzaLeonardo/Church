package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

public interface PersonDeleteUseCase {
    PersonResponseDTO delete(Long id);
}
