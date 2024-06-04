package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "accessory_id", nullable = false)
    private String accessoryId;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "name_accessory", nullable = false)
    private String nameAccessory;

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

    public Accessory(Long id, String accessoryId, String model, String nameAccessory, String description, Brand brand, StatusEquipmentType statusEquipmentType, StatusEquipment statusEquipment, Category category, SubCategory subCategory) {
        this.id = id;
        this.accessoryId = accessoryId;
        this.model = model;
        this.nameAccessory = nameAccessory;
        this.description = description;
        this.brand = brand;
        this.statusEquipmentType = statusEquipmentType;
        this.statusEquipment = statusEquipment;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Accessory() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(String accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameAccessory() {
        return nameAccessory;
    }

    public void setNameAccessory(String nameAccessory) {
        this.nameAccessory = nameAccessory;
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