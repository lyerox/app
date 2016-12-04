package com.iot.domain.cargo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-17.
 */
@Entity
@Getter@Setter
public class LocationType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type")
    private List<Location> locations;

    public LocationType(String type){
        this.type = type;
    }
}
