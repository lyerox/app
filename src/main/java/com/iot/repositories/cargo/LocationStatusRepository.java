package com.iot.repositories.cargo;

import com.iot.domain.cargo.LocationStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyerox on 16-10-27.
 */
@Repository
public interface LocationStatusRepository extends CrudRepository<LocationStatus, Integer> {
}
