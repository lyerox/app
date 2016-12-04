package com.iot.controller;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.Warehouse;
import com.iot.domain.schedule.Plan;
import com.iot.services.Cargo.LocationService;
import com.iot.services.Cargo.WarehouseService;
import com.iot.services.Plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by lyerox on 16-11-16.
 */

@Controller
public class WarehouseController {

    private WarehouseService warehouseService;

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @RequestMapping(value = "/warehouse", method = RequestMethod.GET)
    String showAllWarehouse(Model model){

        List<Warehouse> warehouses = warehouseService.getAllWarehouse();

        warehouses.forEach(warehouse -> {
            List<Location> locations = warehouseService.getLocations(warehouse);
            warehouse.setLocations(locations);
        });

        model.addAttribute("warehouses", warehouses);

        return "warehouse/index";
    }


}
