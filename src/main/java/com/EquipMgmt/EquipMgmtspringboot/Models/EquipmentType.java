package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50, message = "Equipment type name must be between 3 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String nameEquipmentType;

    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "equipmentType", fetch = FetchType.EAGER)
    private List<Equipment> equipments;

    public EquipmentType() {
    }

    public EquipmentType(Long id, String nameEquipmentType, String showHome, String description, List<Equipment> equipments) {
        this.id = id;
        this.nameEquipmentType = nameEquipmentType;
        this.showHome = showHome;
        this.description = description;
        this.equipments = equipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50, message = "Equipment type name must be between 3 and 50 characters") String getNameEquipmentType() {
        return nameEquipmentType;
    }

    public void setNameEquipmentType(@Size(min = 3, max = 50, message = "Equipment type name must be between 3 and 50 characters") String nameEquipmentType) {
        this.nameEquipmentType = nameEquipmentType;
    }

    public @NotBlank String getShowHome() {
        return showHome;
    }

    public void setShowHome(@NotBlank String showHome) {
        this.showHome = showHome;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }

    public void setEquipment(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
