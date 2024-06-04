package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "device_id", nullable = false)
    private String deviceId;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "name_device", nullable = false)
    private String nameDevice;

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


    public Device() {
    }

    public Device(Long id, String deviceId, String model, String nameDevice, String description, Brand brand, StatusEquipment statusEquipment, StatusEquipmentType statusEquipmentType, SubCategory subCategory, Category category) {
        this.id = id;
        this.deviceId = deviceId;
        this.model = model;
        this.nameDevice = nameDevice;
        this.description = description;
        this.brand = brand;
        this.statusEquipment = statusEquipment;
        this.statusEquipmentType = statusEquipmentType;
        this.subCategory = subCategory;
        this.category = category;
    }


    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
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

    public StatusEquipment getStatusEquipment() {
        return statusEquipment;
    }

    public void setStatusEquipment(StatusEquipment statusEquipment) {
        this.statusEquipment = statusEquipment;
    }

    public StatusEquipmentType getStatusEquipmentType() {
        return statusEquipmentType;
    }

    public void setStatusEquipmentType(StatusEquipmentType statusEquipmentType) {
        this.statusEquipmentType = statusEquipmentType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}