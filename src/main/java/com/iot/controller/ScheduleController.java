package com.iot.controller;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;
import com.iot.domain.schedule.Plan;
import com.iot.repositories.plan.PlanRepository;
import com.iot.services.Cargo.WarehouseService;
import com.iot.services.Plan.PlanService;
import com.iot.services.party.PartyService;
import com.iot.services.party.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyerox on 16-11-15.
 */
@Controller
public class ScheduleController {

    private Logger log = Logger.getLogger(ScheduleController.class);

    private PlanService planService;

    @Autowired
    public void setPlanService(PlanService planService){
        this.planService = planService;
    }


    private PartyService partyService;
    @Autowired
    public void setPartyService(PartyService partyService){
        this.partyService = partyService;
    }

    private WarehouseService warehouseService;
    @Autowired
    public void setWarehouseService(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    private VehicleService vehicleService;
    @Autowired
    public void setVehicleService(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @ModelAttribute
    public void addSystemType(Model model){
        model.addAttribute("newtype", "queue");
    }

    @RequestMapping("/plans")
    public String showAllPlans(Model model){

        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("plans", planService.getAllPlans());

        return "schedule/plans";
    }

    @RequestMapping(value = "/plan/{planId}", method = RequestMethod.GET)
    public String showPlan(@PathVariable Long planId, Model model){
        //controller logic code

        Plan plan = planService.getPlan(planId);
        model.addAttribute("plan", plan);
        return "schedule/detail";
    }

    @RequestMapping(value = "/plan/new", method = RequestMethod.GET)
    public String createPlan(Model model) {

        model.addAttribute("planstatus", planService.getAllStatus());
//        model.addAttribute("plantypes", planService.getAllTypes());

        //random a partyService
        Plan plan = new Plan();
        Party party = partyService.getPartyById(1L);

        model.addAttribute("supplier", party);
        model.addAttribute("vehicle", vehicleService.getVehicle(4));
        Set<Warehouse> warehouses = warehouseService.getWarehousesByCargoId("random");
        Set<Location> locationSet = plan.getLocations();
        warehouses.forEach(warehouse -> {
            locationSet.add(warehouseService.getOneEmptyLocation(warehouse));
        });
        model.addAttribute("plan", plan);
        return "schedule/form_plan";
    }

    @RequestMapping(value = "/plan/new", method = RequestMethod.POST)
    public String savePlan(@Valid Plan plan, Errors errors){
        if (errors.hasErrors()){
            log.info(errors);
            return "schedule/new";
        }
        //validation the location state
        for(Location location : plan.getLocations()){
            if(location.getStatus().getId() == 1){
                return "schedule/new";
            }
        }
        planService.savePlan(plan);
        return "redirect: plans/";
    }

    @RequestMapping(value = "/plan/{planId}", method = RequestMethod.DELETE)
    @Transactional
    public String deletePlan(@PathVariable Long planId){
        planService.deletePlan(planId);
        return "redirect:/plans";
    }


}
