package com.tapsintown.models;

import javax.persistence.*;

/**
 * Created by anthonyfortney on 1/20/17.
 */
@Entity
@Table(name = "newletter")

public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
}
