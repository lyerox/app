package com.iot.domain.party;

import com.iot.domain.party.Party;
import com.iot.domain.schedule.Plan;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by lyerox on 16-10-17.
 */
@Entity
public class Vehicle implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Getter@Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="number")
    @Getter@Setter
    private String number;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "partyId")
    private Party party;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Plan> planList;

    public String toString(){
        return this.getNumber();
    }

}
