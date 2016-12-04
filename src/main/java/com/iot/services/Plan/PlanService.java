package com.iot.services.Plan;

import com.iot.domain.cargo.Location;
import com.iot.domain.party.Vehicle;
import com.iot.domain.schedule.Plan;
import com.iot.domain.schedule.PlanStatus;
import com.iot.domain.schedule.PlanType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by lyerox on 16-10-17.
 */
public interface PlanService {

    Plan getPlan(Long id);

    void deletePlan(Long id);

    Plan savePlan(Plan plan);

    List<PlanStatus> getAllStatus();

    List<PlanType> getAllTypes();

    List<Plan> getAllPlans();

//    Set<Plan> getPlansByLocation(Location location);

    Page<Plan> getPlansByPage(Pageable pageable);

}
