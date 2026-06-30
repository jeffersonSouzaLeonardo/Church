package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Address;
import com.br.church.memberManager.infra.inbound.rest.dto.AddressRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressRequestDTOToAddress {

    public Address map(AddressRequestDTO addressRequestDTO) {
        if (addressRequestDTO == null) {
            return null;
        }

        Address address = new Address();
        address.setId(addressRequestDTO.getId());
        address.setStreet(addressRequestDTO.getStreet());
        address.setNumber(addressRequestDTO.getNumber());
        address.setComplement(addressRequestDTO.getComplement());
        address.setNeighborhood(addressRequestDTO.getNeighborhood());
        address.setCity(addressRequestDTO.getCity());
        address.setState(addressRequestDTO.getState());
        address.setCep(addressRequestDTO.getCep());
        address.setPersonId(addressRequestDTO.getPersonId());
        return address;
    }
}
