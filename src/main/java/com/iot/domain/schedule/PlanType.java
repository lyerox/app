package com.iot.domain.schedule;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-24.
 */
@Entity
public class PlanType implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter@Setter
    private Integer id;


    @Getter@Setter
    @Column(name = "type")
    private String type;

    @Getter@Setter
    @OneToMany(mappedBy = "type")
    private List<Plan> planList;

}
