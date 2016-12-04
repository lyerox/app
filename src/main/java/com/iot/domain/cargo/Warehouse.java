package com.iot.domain.cargo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by lyerox on 16-10-13.
 */
@Entity
public class Warehouse implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Getter@Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="name")
    @Getter@Setter
    private String name;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    @Getter@Setter
    private List<Location> locations;

    public String toString(){
        return this.getName();
    }

}
