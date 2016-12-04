package com.iot.domain.access;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lyerox on 16-10-24.
 */
@Entity
public class Door implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter@Setter
    private Integer id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Getter @Setter
    @OneToMany(mappedBy = "door")
    private List<AccessRecord> accessRecords;
}
