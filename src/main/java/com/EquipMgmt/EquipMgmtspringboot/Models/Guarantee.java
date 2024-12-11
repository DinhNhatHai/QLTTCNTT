package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "guarantee")
public class Guarantee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "guarantee_id", nullable = false)
    private String guaranteeId;

    @Column(name = "warranty_period", nullable = false)
    private String warrantyPeriod;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "location")
    private String location;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_type_id", nullable = false)
    private EquipmentType equipmentType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", nullable = false)
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @OneToMany(mappedBy = "guarantee", fetch = FetchType.EAGER)
    private List<Warranty> warranties;

    public Guarantee() {
    }

    public Guarantee(Long id, String guaranteeId, String warrantyPeriod, String startDate, String location, String description, EquipmentType equipmentType, Equipment equipment, Vendor vendor, List<Warranty> warranties) {
        this.id = id;
        this.guaranteeId = guaranteeId;
        this.warrantyPeriod = warrantyPeriod;
        this.startDate = startDate;
        this.location = location;
        this.description = description;
        this.equipmentType = equipmentType;
        this.equipment = equipment;
        this.vendor = vendor;
        this.warranties = warranties;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Vendor getVendor () {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<Warranty> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<Warranty> warranties) {
        this.warranties = warranties;
    }
}