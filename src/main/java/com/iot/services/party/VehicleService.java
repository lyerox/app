package com.iot.services.party;

import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by lyerox on 16-11-21.
 */
public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Vehicle getVehicle(Integer id);

    Vehicle getVehicleByNumber(String number);

    List<Vehicle> getVehiclesByParty(Party party);

}
