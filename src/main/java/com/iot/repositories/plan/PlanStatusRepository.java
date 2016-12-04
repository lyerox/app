package com.iot.repositories.plan;

import com.iot.domain.schedule.PlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by lyerox on 16-11-11.
 */
@Repository
public interface PlanStatusRepository extends JpaRepository<PlanStatus, Integer> {
}
