package com.br.church.memberManager.ports.inbound;

import com.br.church.memberManager.infra.inbound.rest.dto.AddressResponseDTO;

public interface AddressUpdateUseCase {
    AddressResponseDTO update(AddressResponseDTO addressResponseDTO);
}
