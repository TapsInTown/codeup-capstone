package com.tapsintown.models;

import javax.persistence.*;

/**
 * Created by anthonyfortney on 1/17/17.
 */
@Entity
@Table(name = "role")
public class Role {

//    Generate table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String role;


//    Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
