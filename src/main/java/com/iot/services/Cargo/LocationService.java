package com.iot.services.Cargo;

import com.iot.domain.cargo.*;
import com.iot.domain.cargo.Location;
import com.iot.domain.schedule.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lyerox on 16-10-17.
 */
public interface LocationService {

    Location getLocation(Integer locationId);

    Set<Plan> getPlans(Location location);

    List<Location> getAllLocations();

//    LocationStatus getStatus(Location location);

//    LocationType getType(Location location);

}
