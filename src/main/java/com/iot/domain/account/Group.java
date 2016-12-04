package com.iot.domain.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by lyerox on 16-10-12.
 */
@Entity
public class Group implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Getter@Setter
    private String id;

    @Column(name = "NAME")
    @Getter@Setter
    private String name;

    @Column(name = "type")
    @Getter@Setter
    private String type;

    @Getter@Setter
    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    public Group(){

    }


}
