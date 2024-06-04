package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "equipment_system")
public class EquipmentSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "equipment_system_id", nullable = false)
    private String equipmentSystemId;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "name_equipment_system", nullable = false)
    private String nameEquipmentSystem;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_equipment_type_id", nullable = false)
    private StatusEquipmentType statusEquipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_equipment_id", nullable = false)
    private StatusEquipment statusEquipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    public EquipmentSystem() {
    }

    public EquipmentSystem(Long id, String equipmentSystemId, String model, String nameEquipmentSystem, String description, Brand brand, StatusEquipmentType statusEquipmentType, StatusEquipment statusEquipment, Category category, SubCategory subCategory) {
        this.id = id;
        this.equipmentSystemId = equipmentSystemId;
        this.model = model;
        this.nameEquipmentSystem = nameEquipmentSystem;
        this.description = description;
        this.brand = brand;
        this.statusEquipmentType = statusEquipmentType;
        this.statusEquipment = statusEquipment;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentSystemId() {
        return equipmentSystemId;
    }

    public void setEquipmentSystemId(String equipmentSystemId) {
        this.equipmentSystemId = equipmentSystemId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameEquipmentSystem() {
        return nameEquipmentSystem;
    }

    public void setNameEquipmentSystem(String nameEquipmentSystem) {
        this.nameEquipmentSystem = nameEquipmentSystem;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public StatusEquipmentType getStatusEquipmentType() {
        return statusEquipmentType;
    }

    public void setStatusEquipmentType(StatusEquipmentType statusEquipmentType) {
        this.statusEquipmentType = statusEquipmentType;
    }

    public StatusEquipment getStatusEquipment() {
        return statusEquipment;
    }

    public void setStatusEquipment(StatusEquipment statusEquipment) {
        this.statusEquipment = statusEquipment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}