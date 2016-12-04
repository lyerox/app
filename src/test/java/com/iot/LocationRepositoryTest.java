package com.iot;

import com.iot.domain.cargo.Location;
import com.iot.domain.party.Party;
import com.iot.domain.party.PartyType;
import com.iot.domain.party.Vehicle;
import com.iot.domain.cargo.LocationStatus;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.schedule.Plan;
import com.iot.domain.schedule.PlanStatus;
import com.iot.domain.schedule.PlanType;
import com.iot.repositories.cargo.LocationRepository;
import com.iot.repositories.party.PartyRepository;
import com.iot.repositories.party.VehicleRepository;
import com.iot.repositories.plan.PlanRepository;
import com.iot.repositories.plan.PlanStatusRepository;
import com.iot.repositories.plan.PlanTypeRepository;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by lyerox on 16-11-11.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PlanStatusRepository planStatusRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    PlanTypeRepository planTypeRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PartyRepository partyRepository;

    public void InitialCargoData(){

        LocationStatus empty = new LocationStatus();
        empty.setStatus("empty");
        LocationStatus occupied = new LocationStatus();
        occupied.setStatus("occupied");

        entityManager.persist(empty);
        entityManager.persist(occupied);

        for(int i =0; i< 3; i++){
            Warehouse warehouse = new Warehouse();
            warehouse.setName(String.valueOf(i));
            entityManager.persist(warehouse);
            for(int j=0; j < 3; j++){
                Location location = new Location();
                location.setStatus(empty);
                location.setWarehouse(warehouse);
                entityManager.persist(location);
            }
        }


    }

    public void InitialPlanStaticData(){
        PlanStatus onTask = new PlanStatus();
        PlanStatus inWaited = new PlanStatus();
        onTask.setName("on");
        inWaited.setName("waitting");
        entityManager.persist(onTask);
        entityManager.persist(inWaited);

        PlanType normal = new PlanType();
        PlanType urgent = new PlanType();
        normal.setType("normal");
        urgent.setType("urgent");
        entityManager.persist(normal);
        entityManager.persist(urgent);
    }

    public void InitialPartyData(){

        PartyType supplier = new PartyType();
        supplier.setName("supplier");
        entityManager.persist(supplier);

        PartyType corp = new PartyType();
        corp.setName("corp");
        entityManager.persist(corp);

        for(int i = 0 ; i < 4; i++){
            Party party = new Party();
            party.setName("party" + String.valueOf(i));
            if( (i % 2) == 0){
                party.setType(supplier);
            }else{
                party.setType(corp);
            }

            entityManager.persist(party);

            for(int j = 0; j< 3; j++){
                Vehicle vehicle = new Vehicle();
                vehicle.setParty(party);
                vehicle.setNumber("party-" + String.valueOf(i) + "-id-" + String.valueOf(j));
                entityManager.persist(vehicle);
            }
        }

    }

    @Test
    public void testExample() throws Exception {
        InitialCargoData();
        InitialPartyData();
        InitialPlanStaticData();
        Plan plan = new Plan();

//        plan.setLocations(locationRepository.getOne(1));
        plan.setType(planTypeRepository.findOne(1));
        plan.setStatus(planStatusRepository.findOne(1));
        plan.setSupplier(partyRepository.findOne(Long.valueOf(1)));
        plan.setUserId("userOne");
        Vehicle vehicle = vehicleRepository.findOne(1);

        plan.setVehicle(vehicle);
        Set<Location> locations = plan.getLocations();

        for(int i=1; i<=3; i++){
            locations.add(locationRepository.findOne(i));
        }
        entityManager.persist(plan);

//        Location location = locationRepository.getOne(1);
        Plan newplan = planRepository.findOne(Long.valueOf(1));
        assertEquals(newplan.getLocations().size(), 3);

        Location location = locationRepository.findOne(1);
        assertEquals(location.getPlans().isEmpty(), false);


//        assertEquals(plan.getLocation(), location);

    }
}
