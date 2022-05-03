package com.securanalyst.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="visits")
public class Visits implements Serializable {
    @Id
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="plate-id")
    private Car car;

    @Column(name = "repair")
    private Date repair;

    @Column(name = "descr")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRepair() {
        return repair;
    }

    public void setRepair(Date repair) {
        this.repair = repair;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
