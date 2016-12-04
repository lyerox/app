package com.iot.bootstrap;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.LocationStatus;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.party.Party;
import com.iot.domain.party.PartyType;
import com.iot.domain.party.Vehicle;
import com.iot.domain.schedule.Plan;
import com.iot.domain.schedule.PlanStatus;
import com.iot.domain.schedule.PlanType;
import com.iot.repositories.cargo.LocationRepository;
import com.iot.repositories.cargo.LocationStatusRepository;
import com.iot.repositories.cargo.LocationTypeRepository;
import com.iot.repositories.cargo.WarehouseRepository;
import com.iot.repositories.party.PartyRepository;
import com.iot.repositories.party.PartyTypeRepository;
import com.iot.repositories.party.VehicleRepository;
import com.iot.repositories.plan.PlanRepository;
import com.iot.repositories.plan.PlanStatusRepository;
import com.iot.repositories.plan.PlanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by lyerox on 16-11-15.
 */
@Component
public class DatasourceInitial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private LocationStatusRepository locationStatusRepository;


    @Autowired
    private PlanStatusRepository planStatusRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private PlanTypeRepository planTypeRepository;

    private PlanRepository planRepository;

    @Autowired
    public void setPlanRepository(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PartyTypeRepository partyTypeRepository;

    private void InitialCargoData(){

        LocationStatus empty = new LocationStatus();
        empty.setStatus("空闲");
        LocationStatus occupied = new LocationStatus();
        occupied.setStatus("占用");

        locationStatusRepository.save(empty);
        locationStatusRepository.save(occupied);

        for(int i =0; i< 3; i++){
            Warehouse warehouse = new Warehouse();
            warehouse.setName("仓库" + String.valueOf(i+1));
            warehouseRepository.save(warehouse);
            for(int j=0; j < 10; j++){
                Location location = new Location();
                if(j % 3 == 0) {
                    location.setStatus(empty);
                }else{
                    location.setStatus(occupied);
                }
                location.setWarehouse(warehouse);
                locationRepository.save(location);
            }
        }


    }

    private void InitialPlanStaticData(){
        PlanStatus onTask = new PlanStatus();
        onTask.setName("执行中");
        PlanStatus inWaited = new PlanStatus();
        inWaited.setName("等待中");
        planStatusRepository.save(onTask);
        planStatusRepository.save(inWaited);


        PlanType normal = new PlanType();
        PlanType urgent = new PlanType();
        planTypeRepository.save(normal);
        planTypeRepository.save(urgent);

    }

    private void InitialPartyData(){

        PartyType supplier = new PartyType();
        supplier.setName("supplier");
        partyTypeRepository.save(supplier);

        PartyType corp = new PartyType();
        corp.setName("corp");
        partyTypeRepository.save(corp);

        for(int i = 0 ; i < 4; i++){
            Party party = new Party();
            party.setName("供应商" + String.valueOf(i));
            if( (i % 2) == 0){
                party.setType(supplier);
            }else{
                party.setType(corp);
            }

            partyRepository.save(party);

            for(int j = 0; j< 20; j++){
                Vehicle vehicle = new Vehicle();
                vehicle.setParty(party);
                String numberEnd = (j>=10)? String.valueOf(j) : "0" + String.valueOf(j) ;
                vehicle.setNumber("鄂J-999" + numberEnd);
                vehicleRepository.save(vehicle);
            }
        }

    }

    private Logger log = Logger.getLogger(DatasourceInitial.class);

    private void InitialPlan() {

        for (int i = 1; i <= 4; i++) {
            Plan plan = new Plan();
            plan.setType(planTypeRepository.findOne(1));
            PlanStatus status = planStatusRepository.findOne(i % 2 + 1);
            plan.setStatus(status);
            Party supplier = partyRepository.findOne(Long.valueOf(i));
//            Vehicle vehicle =  supplier.getVehicles().get(i);

            plan.setNumber("NO.0000" + String.valueOf(i));

            plan.setVehicle(vehicleRepository.findOne(i * 10));
            plan.setStartTime(new Date());
            plan.setEndTime(new Date());
            Set<Location> locations = plan.getLocations();

            for (int j = 0;j < 3; j++) {
                Location location = locationRepository.findOne( j + i);
                locations.add(location);
            }
            planRepository.save(plan);
        }
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event){
        InitialCargoData();
        InitialPartyData();
        InitialPlanStaticData();
        InitialPlan();

        log.info("initializer completed");

        List<Plan> planList = planRepository.findAll();

        planList.forEach(plan -> {
            plan.getLocations().forEach(location -> {
                log.info(location.getId());
            });
        });

    }

}
