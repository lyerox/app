package com.iot.domain.cargo;

import com.iot.domain.schedule.Plan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyerox on 16-10-13.
 */
@Entity
@Getter@Setter
public class Location implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="currentVehicle")
    private String vehicleNum;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private LocationStatus status;

    @ManyToOne
    @JoinColumn(name = "warehouseId")
    private Warehouse warehouse;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE },
            targetEntity = Plan.class)
    @JoinTable(name="plan_location",
            joinColumns = @JoinColumn(name="location_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name="plan_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private final Set<Plan> plans = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "typeId")
    private LocationType type;

}
