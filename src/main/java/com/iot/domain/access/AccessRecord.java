package com.iot.domain.access;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by lyerox on 16-10-24.
 */
@Entity
@Getter@Setter
public class AccessRecord implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "door_id")
    private Door door;

    @Column(name="action")
    private String action;

    @Column(name = "time")
    private Date time;

    @Column(name = "vehicleNum")
    private String vehicleNum;
}
