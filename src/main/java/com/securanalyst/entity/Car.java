package com.securanalyst.entity;

import io.micronaut.data.annotation.Join;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="car", schema = "car")
public class Car implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Visits> visit = new HashSet<>();


    @OneToOne()
    @JoinColumn(name="type_id", referencedColumnName = "id")
    private Typez typec;

    @Column(name="reg")
    private String registration;

    @Column(name="date")
    private Date date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
