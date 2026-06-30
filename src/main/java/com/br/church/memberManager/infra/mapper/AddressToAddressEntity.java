package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Address;
import com.br.church.memberManager.infra.outbound.persistence.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressEntity {

    public AddressEntity map(Address address) {
        if (address == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(address.getId());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setNumber(address.getNumber());
        addressEntity.setComplement(address.getComplement());
        addressEntity.setNeighborhood(address.getNeighborhood());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCep(address.getCep());
        return addressEntity;
    }
}
