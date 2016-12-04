package com.iot.services.Cargo;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.LocationStatus;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.schedule.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by lyerox on 16-11-16.
 */
public interface WarehouseService {
    Warehouse getWarehouse(Integer warehouseId);

    List<Warehouse> getAllWarehouse();

    List<Location> getLocations(Warehouse warehouse);

    Location getOneEmptyLocation(Warehouse warehouses);

    Set<Location> getEmptyLocations(Warehouse warehouse);

    Set<Warehouse> getWarehousesByCargoId(String cargoNumber);

}
