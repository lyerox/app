package com.iot.controller;

import com.iot.domain.cargo.Location;
import com.iot.domain.schedule.Plan;
import com.iot.services.Cargo.LocationService;
import com.iot.services.Plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by lyerox on 16-11-10.
 */
@Controller
public class LocationController {

    @Autowired
    private PlanService planService;

    @Autowired
    private  LocationService locationService;

    @RequestMapping(value = "/location/{locationid}", method = RequestMethod.GET)
    public String showLocation(@PathVariable("locationid") Integer locationId, Model model){

        Location location = locationService.getLocation(locationId);
        Set<Plan> plans = locationService.getPlans(location);
        model.addAttribute("plans", plans);
        model.addAttribute("location", location);
        return "location/show";
    }

    @RequestMapping(value = "/location/{locationid}/edit", method = RequestMethod.GET)
    public String editLocation(@PathVariable Integer locationId, Model model){

        Location location = locationService.getLocation(locationId);
        Set<Plan> plans = locationService.getPlans(location);
        model.addAttribute("plans", plans);
        model.addAttribute("location", location);
        return "location/edit";
    }

    @RequestMapping(value = "/location/{locationid}/plan/new", method = RequestMethod.GET)
    public String newPlan(@PathVariable Integer locationId, Model model){
        Location location = locationService.getLocation(locationId);
        if(location != null){
            Plan plan = new Plan();
            Set<Location> locationSet = plan.getLocations();
            locationSet.add(location);

            model.addAttribute("Plan", plan);
            return "/plan/new";
        }else{
            return "error/404";
        }
    }

}
