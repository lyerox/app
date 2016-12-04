package com.iot.repositories.cargo;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.LocationStatus;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.schedule.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by lyerox on 16-10-17.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

    Page<Location> findAll(Pageable pageable);

    List<Location> findByWarehouse(Warehouse warehouse);

    Page<Location> findByWarehouseAndStatus(Warehouse warehouse, LocationStatus status, Pageable pageable);

    Set<Location> findByWarehouseAndStatus(Warehouse warehouse, LocationStatus status);

//    List<Location> findByStatusId(Integer statusId);

//    Set<Location> findByPlans_id(Integer plansId);

//    Set<Location> findByPlans(Plan plan);

//    List<Location> findByStatusIdAndTypeId(Integer statusId, Integer typeId);

}
