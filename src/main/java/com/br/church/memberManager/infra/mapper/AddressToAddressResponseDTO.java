package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Address;
import com.br.church.memberManager.infra.inbound.rest.dto.AddressResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressToAddressResponseDTO {

    public AddressResponseDTO map(Address address) {
        if (address == null) {
            return null;
        }

        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setId(address.getId());
        addressResponseDTO.setStreet(address.getStreet());
        addressResponseDTO.setNumber(address.getNumber());
        addressResponseDTO.setComplement(address.getComplement());
        addressResponseDTO.setNeighborhood(address.getNeighborhood());
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setState(address.getState());
        addressResponseDTO.setCep(address.getCep());
        addressResponseDTO.setPersonId(address.getPersonId());
        return addressResponseDTO;
    }

    public List<AddressResponseDTO> map(List<Address> addresses) {
        if (addresses == null) {
            return null;
        }

        List<AddressResponseDTO> addressResponseDTOS = new ArrayList<>();
        for (Address address : addresses) {
            addressResponseDTOS.add(map(address));
        }
        return addressResponseDTOS;
    }
}
