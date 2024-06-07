package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "maintenance_type")
public class MaintenanceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3 , max = 50)
    @Column(name = "name", length = 50)
    private String nameMaintenanceType;

    @Column(name = "show_home")
    private String showHome;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;


    public MaintenanceType() {
    }

    public MaintenanceType(Long id, String nameMaintenanceType, String showHome, String description) {
        this.id = id;
        this.nameMaintenanceType = nameMaintenanceType;
        this.showHome = showHome;
        this.description = description;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMaintenanceType() {
        return nameMaintenanceType;
    }

    public void setNameMaintenanceType(String nameMaintenanceType) {
        this.nameMaintenanceType = nameMaintenanceType;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }
}
