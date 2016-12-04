package com.iot.domain.account;

import com.iot.domain.party.Party;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-12.
 */
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter@Setter
    private String id;

    @Column(name = "name")
    @Getter@Setter
    private String name;

    @Column(name = "password")
    @Getter@Setter
    private String password;

    @Getter@Setter
    @ManyToMany
//    @JoinTable(name = "ACT_ID_MEMBERSHIP", joinColumns = {@JoinColumn(name = "USER_ID_")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID_")})
    private List<Group> groups;

    @Getter@Setter
    @ManyToOne
    @JoinColumn(name = "partyId")
    private Party party;

    public User(){

    }
}
