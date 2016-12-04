package com.iot.services.party;

import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;

import java.util.List;

/**
 * Created by lyerox on 16-11-21.
 */
public interface PartyService {

    List<Party> getAllParties();

    List<Vehicle> getVehiclesOfParty(Party party);

    Party getPartyById(Long id);

}
