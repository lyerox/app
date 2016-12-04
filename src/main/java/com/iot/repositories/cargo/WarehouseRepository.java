package com.iot.repositories.cargo;

import com.iot.domain.cargo.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyerox on 16-10-18.
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
