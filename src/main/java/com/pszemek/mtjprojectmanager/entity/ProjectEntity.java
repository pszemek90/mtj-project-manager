package com.pszemek.mtjprojectmanager.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    private UUID uuid;
    private String number;
    private String title;
    private String customer;


    public UUID getUuid() {
        return uuid;
    }

    public String getNumber() {
        return number;
    }

    public ProjectEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProjectEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ProjectEntity setCustomer(String customer) {
        this.customer = customer;
        return this;
    }
}
