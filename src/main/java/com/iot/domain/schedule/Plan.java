package com.iot.domain.schedule;

import com.iot.domain.cargo.Location;
import com.iot.domain.party.Party;
import com.iot.domain.party.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by lyerox on 16-10-12.
 */
@Entity
@Getter@Setter
public class Plan implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nunmber")
    private String number;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "startTime")
    private Date startTime;

    @Column(name = "endTime")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private PlanType type;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private PlanStatus status;



    @ManyToOne
    @JoinColumn(name="vehicleId")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="supplierId")
    private Party supplier;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE },
            targetEntity = Location.class)
    @JoinTable(name="plan_location",
            joinColumns = @JoinColumn(name="plan_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name="location_id", nullable = false, updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private final Set<Location> locations = new HashSet<>();

}
