package com.iot.repositories.plan;

import com.iot.domain.schedule.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by lyerox on 16-11-11.
 */
@Repository
public interface PlanTypeRepository extends JpaRepository<PlanType, Integer> {
}
