package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "maintenance_description")
public class MaintenanceDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String nameMaintenanceDescription;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @Column(name = "show_home")
    private String showHome;

    @OneToMany(mappedBy = "maintenanceDescription", fetch = FetchType.EAGER)
    private List<Maintenance> maintenances;

    public MaintenanceDescription() {
    }

    public MaintenanceDescription(Long id, String nameMaintenanceDescription, String description, String showHome, List<Maintenance> maintenances) {
        this.id = id;
        this.nameMaintenanceDescription = nameMaintenanceDescription;
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

    public String getNameMaintenanceDescription() {
        return nameMaintenanceDescription;
    }

    public void setNameMaintenanceDescription(String nameMaintenanceDescription) {
        this.nameMaintenanceDescription = nameMaintenanceDescription;
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

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }
}
