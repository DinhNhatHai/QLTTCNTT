package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "status_equipment")
public class StatusEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 5, max = 50)
    @Column(name = "name")
    private String nameStatus;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @DecimalMin(value = "0.0", inclusive = true, message = "Depreciation must be positive")
    @Column(name = "depreciation")
    private Double depreciation;

    @OneToMany(mappedBy = "statusEquipment", fetch = FetchType.EAGER)
    private List<Equipment> equipments;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "status_equipment_type_id", nullable = false)
    private StatusEquipmentType statusEquipmentType;


    public StatusEquipment() {
    }

    public StatusEquipment(Long id, String nameStatus, String description, String showHome, Double depreciation, List<Equipment> equipments, StatusEquipmentType statusEquipmentType) {
        this.id = id;
        this.nameStatus = nameStatus;
        this.description = description;
        this.showHome = showHome;
        this.depreciation = depreciation;
        this.equipments = equipments;
        this.statusEquipmentType = statusEquipmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 5, max = 50) String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(@Size(min = 5, max = 50) String nameStatus) {
        this.nameStatus = nameStatus;
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

    public @DecimalMin(value = "0.0", inclusive = true, message = "Depreciation must be positive") Double getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(@DecimalMin(value = "0.0", inclusive = true, message = "Depreciation must be positive") Double depreciation) {
        this.depreciation = depreciation;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public StatusEquipmentType getStatusEquipmentType() {
        return statusEquipmentType;
    }

    public void setStatusEquipmentType(StatusEquipmentType statusEquipmentType) {
        this.statusEquipmentType = statusEquipmentType;
    }
}
