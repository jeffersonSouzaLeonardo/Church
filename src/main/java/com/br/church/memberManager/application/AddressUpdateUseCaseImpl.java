package com.br.church.memberManager.application;

import com.br.church.memberManager.infra.inbound.rest.dto.AddressResponseDTO;
import com.br.church.memberManager.infra.mapper.AddressRequestDTOToAddress;
import com.br.church.memberManager.ports.inbound.AddressUpdateUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddressUpdateUseCaseImpl implements AddressUpdateUseCase {

    public AddressUpdateUseCaseImpl(AddressRequestDTOToAddress addressRequestDTOToAddress) {
        this.addressRequestDTOToAddress = addressRequestDTOToAddress;
    }



    private final AddressRequestDTOToAddress addressRequestDTOToAddress;

    @Override
    public AddressResponseDTO update(AddressResponseDTO addressResponseDTO) {


        return null;
    }
}
