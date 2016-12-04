package com.iot.domain.schedule;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-24.
 */
@Entity
@Getter@Setter
public class PlanStatus implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Plan> planList;


    public String toString(){
        return this.getName();
    }

}
