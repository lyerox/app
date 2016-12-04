package com.iot.services.Cargo;

import com.iot.domain.cargo.Location;
import com.iot.domain.cargo.LocationStatus;
import com.iot.domain.cargo.Warehouse;
import com.iot.repositories.cargo.LocationRepository;
import com.iot.repositories.cargo.LocationStatusRepository;
import com.iot.repositories.cargo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by lyerox on 16-11-16.
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private LocationRepository locationRepository;

    private WarehouseRepository warehouseRepository;

    private LocationStatusRepository statusRepository;

    @Autowired
    public void setStatusRepository(LocationStatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Autowired
    public void setWarehouseRepository(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse getWarehouse(Integer warehouseId){
        return warehouseRepository.getOne(warehouseId);
    }
    @Override
    public List<Warehouse> getAllWarehouse(){
        return warehouseRepository.findAll();
    }

    @Override
    public List<Location> getLocations(Warehouse warehouse){
        return locationRepository.findByWarehouse(warehouse);
    }

    @Override
    public Location getOneEmptyLocation(Warehouse warehouse){

        LocationStatus empty = statusRepository.findOne(1);
        Pageable onlyOne = new PageRequest(0, 1, Sort.Direction.ASC, "id");
        Page<Location> locationPage = locationRepository.findByWarehouseAndStatus(warehouse, empty, onlyOne);

        if(locationPage.getTotalPages() <= 0){
            return null;
        }else {
            return locationPage.getContent().get(0);
        }
    }

    @Override
    public Set<Location> getEmptyLocations(Warehouse warehouse){

        LocationStatus empty = statusRepository.findOne(1);
        return locationRepository.findByWarehouseAndStatus(warehouse, empty);
    }

    @Override
    //Note! This method generate random a set of warehouse
    // not truly generate by cargo constrains.
    public Set<Warehouse> getWarehousesByCargoId(String cargoNumber){
        Random random = new Random();
        int count = random.nextInt(3) + 1;
        Set<Warehouse> warehouses = new HashSet<>();
        for(int i = 1; i <= count; i++){
            warehouses.add(warehouseRepository.findOne(i));
        }
        return  warehouses;
    }


}
