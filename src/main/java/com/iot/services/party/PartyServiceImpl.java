package com.iot.services.party;

import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;
import com.iot.repositories.party.PartyRepository;
import com.iot.repositories.party.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lyerox on 16-11-21.
 */
@Service
public class PartyServiceImpl implements PartyService{

    private PartyRepository partyRepository;

    @Autowired
    public void setPartyRepository(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
    }

    private VehicleRepository vehicleRepository;

    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Party> getAllParties(){
        return partyRepository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesOfParty(Party party){
        return vehicleRepository.findByPartyId(party.getId());
    }

    @Override
    public Party getPartyById(Long id){
        return partyRepository.findOne(id);
    }


}
