package com.br.church.memberManager.infra.mapper;

import com.br.church.memberManager.domain.model.Address;
import com.br.church.memberManager.infra.outbound.persistence.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressEntityToAddress {

    public Address map(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }

        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setStreet(addressEntity.getStreet());
        address.setNumber(addressEntity.getNumber());
        address.setComplement(addressEntity.getComplement());
        address.setNeighborhood(addressEntity.getNeighborhood());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCep(addressEntity.getCep());
        return address;
    }

    public List<Address> map(List<AddressEntity> addressEntities) {
        if (addressEntities == null) {
            return null;
        }

        List<Address> addresses = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities) {
            addresses.add(map(addressEntity));
        }
        return addresses;
    }
}
