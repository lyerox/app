package com.iot.repositories.party;

import com.iot.domain.party.PartyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyerox on 16-11-15.
 */
@Repository
public interface PartyTypeRepository extends CrudRepository<PartyType, Integer>{
}
