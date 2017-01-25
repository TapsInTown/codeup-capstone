package com.tapsintown.models;

import javax.persistence.*;

/**
 * Created by anthonyfortney on 1/17/17.
 */
@Entity
@Table(name = "role")
public class UserRole {

//    Generate table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(nullable = false)
    private String role = "user";

    public UserRole(long userId) {
        this.userId = userId;
    }

    public UserRole(){}

    //    Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
