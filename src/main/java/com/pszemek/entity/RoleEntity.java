package com.pszemek.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

    public Integer getId() {
        return id;
    }

    public RoleEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public RoleEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
