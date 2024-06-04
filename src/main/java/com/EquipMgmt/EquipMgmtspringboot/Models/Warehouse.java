package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

//    @NotNull
//    @Column(name = "show_home", nullable = false)
//    private Boolean showHome;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;


    public Warehouse(){

    }

    public Warehouse(Long id, String name, String location, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
//        this.showHome = showHome;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public void setName(@Size(min = 3, max = 50) String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public @NotNull Boolean getShowHome() {
//        return showHome;
//    }
//
//    public void setShowHome(@NotNull Boolean showHome) {
//        this.showHome = showHome;
//    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }
}


