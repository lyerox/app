package com.iot.repositories.party;

import com.iot.domain.party.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lyerox on 16-10-25.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByPartyId(Long partyId);
    List<Vehicle> findAll();
    Vehicle findByNumber(String number);
}
