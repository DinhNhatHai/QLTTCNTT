package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "maintenance_status")
public class MaintenanceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "Status must be less than 50 characters")
    @Column(name = "name_status", nullable = false)
    private String nameMaintenanceStatus;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @Column(name = "show_home")
    private String showHome;

    @OneToMany(mappedBy = "maintenanceStatus", fetch = FetchType.EAGER)
    private Set<Maintenance> maintenances;

    public MaintenanceStatus() {}

    public MaintenanceStatus(Long id, String nameMaintenanceStatus, String description, String showHome, Set<Maintenance> maintenances) {
        this.id = id;
        this.nameMaintenanceStatus = nameMaintenanceStatus;
        this.description = description;
        this.showHome = showHome;
        this.maintenances = maintenances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(max = 50, message = "Status must be less than 50 characters") String getNameMaintenanceStatus() {
        return nameMaintenanceStatus;
    }

    public void setNameMaintenanceStatus(@Size(max = 50, message = "Status must be less than 50 characters") String nameMaintenanceStatus) {
        this.nameMaintenanceStatus = nameMaintenanceStatus;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }

    public Set<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(Set<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }
}
