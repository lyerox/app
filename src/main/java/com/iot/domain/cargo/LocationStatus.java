package com.iot.domain.cargo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lyerox on 16-10-26.
 */
@Entity
@Getter@Setter
public class LocationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "status")
    private List<Location> locations;

    public String toString(){
        return getStatus();
    }
}
