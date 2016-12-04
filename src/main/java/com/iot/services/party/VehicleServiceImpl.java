package com.iot.services.party;

import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;
import com.iot.repositories.party.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lyerox on 16-11-21.
 */
@Service
public class VehicleServiceImpl implements  VehicleService{

    private VehicleRepository vehicleRepository;
    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByParty(Party party){
        return vehicleRepository.findByPartyId(party.getId());
    }

    @Override
    public Vehicle getVehicle(Integer id){
        return vehicleRepository.findOne(id);
    }
    @Override
    public Vehicle getVehicleByNumber(String number){
        return vehicleRepository.findByNumber(number);
    }
}
