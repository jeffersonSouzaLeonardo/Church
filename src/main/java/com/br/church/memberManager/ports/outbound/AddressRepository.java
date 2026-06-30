package com.br.church.memberManager.ports.outbound;

import com.br.church.memberManager.infra.outbound.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface AddressRepository extends JpaRepository<Long, AddressEntity> {


}
