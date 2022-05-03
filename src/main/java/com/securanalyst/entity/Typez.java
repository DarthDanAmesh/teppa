package com.securanalyst.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type")
public class Typez implements Serializable {
    @Id
    @Column(name="id")
    private Long id;

    @OneToMany(mappedBy = "typec", cascade = CascadeType.ALL)
    private Set<Car> car = new HashSet<>();


    @Column(name="name")
    private Boolean name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getName() {
        return name;
    }

    public void setName(Boolean name) {
        this.name = name;
    }
}
