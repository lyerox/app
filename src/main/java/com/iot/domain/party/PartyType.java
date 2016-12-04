package com.iot.domain.party;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-24.
 */
@Entity
public class PartyType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;

    @Column(name="name")
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Party> partyList;

    public String toString(){
        return this.getName();
    }

}
