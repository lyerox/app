package com.iot.repositories.plan;

import com.iot.domain.cargo.Location;
import com.iot.domain.schedule.Plan;
import com.iot.domain.schedule.PlanStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by lyerox on 16-10-13.
 */
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

    Page<Plan> findAll(Pageable pageable);

    Set<Plan> findAllByLocations(Location location);

}
