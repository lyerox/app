package com.iot.services.Cargo;

import com.iot.domain.cargo.Location;
import com.iot.domain.schedule.Plan;
import com.iot.repositories.cargo.LocationRepository;
import com.iot.repositories.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by lyerox on 16-10-18.
 */
@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;

    private PlanRepository planRepository;


    @Autowired
    public void setLocationRepository(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    @Autowired
    public void setPlanRepository(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    @Override
    public Location getLocation(Integer locationId){
        return locationRepository.findOne(locationId);
    }

    @Override
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @Override
    public Set<Plan> getPlans(Location location){
        return planRepository.findAllByLocations(location);
    }

}
