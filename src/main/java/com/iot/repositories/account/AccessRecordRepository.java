package com.iot.repositories.account;

import com.iot.domain.access.AccessRecord;
import com.iot.domain.access.Door;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lyerox on 16-10-27.
 */
@Repository
public interface AccessRecordRepository extends JpaRepository<AccessRecord, Long>{

    Page<AccessRecord> findAll(Pageable pageable);

//    List<AccessRecord> findTimeBetween(Date startTime, Date endTime);

    List<AccessRecord> findAllByDoorId(Integer doorId);

//    List<AccessRecord> findByTimeBetweenAndActionId(Date startTime, Date endTime, Integer actionId);

    List<AccessRecord> findByVehicleNum(String vehicleNum);

}
