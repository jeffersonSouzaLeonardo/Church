package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

public interface PersonUpdateUseCase {
    PersonResponseDTO update(Long id, PersonRequestDTO personRequestDTO);
}
