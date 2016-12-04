package com.iot.domain.party;

import com.iot.domain.account.User;
import com.iot.domain.schedule.Plan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-17.
 */
@Entity
public class Party implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter@Setter
    private Long id;

    @Column(name="name")
    @Getter@Setter
    private String name;

    @Getter@Setter
    @ManyToOne
    @JoinColumn(name = "typeId")
    private PartyType type;

    @OneToMany(mappedBy = "party")
    @Getter@Setter
    private List<User> users ;

    @OneToMany(mappedBy = "party")
    @Getter@Setter
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "supplier")
    @Getter@Setter
    private List<Plan> planList;

    public String toString(){
        return this.getName();
    }

}
