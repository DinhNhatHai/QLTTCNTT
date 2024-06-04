package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "status_equipment_type")
public class StatusEquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 5, max = 50)
    @Column(name = "name")
    private String nameStatusType;

    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "statusEquipmentType", fetch = FetchType.EAGER)
    private List<StatusEquipment> statusEquipments;

    @OneToMany(mappedBy = "statusEquipmentType", fetch = FetchType.EAGER)
    private List<Device> devices;

    public StatusEquipmentType() {
    }

    public StatusEquipmentType(Long id, String nameStatusType, String showHome, String description, List<StatusEquipment> statusEquipments, List<Device> devices) {
        this.id = id;
        this.nameStatusType = nameStatusType;
        this.showHome = showHome;
        this.description = description;
        this.statusEquipments = statusEquipments;
        this.devices = devices;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 5, max = 50) String getNameStatusType() {
        return nameStatusType;
    }

    public void setNameStatusType(@Size(min = 5, max = 50) String nameStatusType) {
        this.nameStatusType = nameStatusType;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public @NotBlank String getShowHome() {
        return showHome;
    }

    public void setShowHome(@NotBlank String showHome) {
        this.showHome = showHome;
    }

    public List<StatusEquipment> getStatusEquipments() {
        return statusEquipments;
    }

    public void setStatusEquipments(List<StatusEquipment> statusEquipments) {
        this.statusEquipments = statusEquipments;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
