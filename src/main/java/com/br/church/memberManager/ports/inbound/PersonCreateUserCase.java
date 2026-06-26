package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;

public interface PersonCreateUserCase {
   PersonResponseDTO create(PersonRequestDTO personRequestDTO);
}
