package com.iot.repositories.cargo;

import com.iot.domain.cargo.LocationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by lyerox on 16-10-27.
 */
@Repository
public interface LocationTypeRepository extends CrudRepository<LocationType, Integer> {
}
