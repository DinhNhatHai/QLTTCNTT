package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "model", nullable = true)
    private String model;

    @Column(name = "name_equipment", nullable = false)
    private String nameEquipment;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "equipment_type_id", nullable = false)
    private EquipmentType equipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_equipment_type_id", nullable = false)
    private StatusEquipmentType statusEquipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_equipment_id", nullable = false)
    private StatusEquipment statusEquipment;

    @OneToMany(mappedBy = "originalEquipment", fetch = FetchType.EAGER)
    private List<ReplacementUpgradeTicket> originalReplacementUpgradeTickets;

    @OneToMany(mappedBy = "newEquipment", fetch = FetchType.EAGER)
    private List<ReplacementUpgradeTicket> newReplacementUpgradeTickets;

    @OneToMany(mappedBy = "equipment", fetch = FetchType.EAGER)
    private List<Maintenance> maintenances;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = true)
    private Receipt receipt;

    @OneToOne(mappedBy = "equipment")
    private DeliveryBill deliveryBill;

    @OneToOne(mappedBy = "equipment")
    private Guarantee guarantee;

    public Equipment() {
    }

    public Equipment(Long id, String serialNumber, String model, String nameEquipment, String description, EquipmentType equipmentType, Category category, Brand brand, StatusEquipmentType statusEquipmentType, StatusEquipment statusEquipment, List<ReplacementUpgradeTicket> originalReplacementUpgradeTickets, List<ReplacementUpgradeTicket> newReplacementUpgradeTickets, List<Maintenance> maintenances, Receipt receipt, DeliveryBill deliveryBill, Guarantee guarantee) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.nameEquipment = nameEquipment;
        this.description = description;
        this.equipmentType = equipmentType;
        this.category = category;
        this.brand = brand;
        this.statusEquipmentType = statusEquipmentType;
        this.statusEquipment = statusEquipment;
        this.originalReplacementUpgradeTickets = originalReplacementUpgradeTickets;
        this.newReplacementUpgradeTickets = newReplacementUpgradeTickets;
        this.maintenances = maintenances;
        this.receipt = receipt;
        this.deliveryBill = deliveryBill;
        this.guarantee = guarantee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(@NotNull String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<ReplacementUpgradeTicket> getOriginalReplacementUpgradeTickets() {
        return originalReplacementUpgradeTickets;
    }

    public void setOriginalReplacementUpgradeTickets(List<ReplacementUpgradeTicket> originalReplacementUpgradeTickets) {
        this.originalReplacementUpgradeTickets = originalReplacementUpgradeTickets;
    }

    public List<ReplacementUpgradeTicket> getNewReplacementUpgradeTickets() {
        return newReplacementUpgradeTickets;
    }

    public void setNewReplacementUpgradeTickets(List<ReplacementUpgradeTicket> newReplacementUpgradeTickets) {
        this.newReplacementUpgradeTickets = newReplacementUpgradeTickets;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public DeliveryBill getDeliveryBill() {
        return deliveryBill;
    }

    public void setDeliveryBill(DeliveryBill deliveryBill) {
        this.deliveryBill = deliveryBill;
    }

    public Guarantee getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }
}