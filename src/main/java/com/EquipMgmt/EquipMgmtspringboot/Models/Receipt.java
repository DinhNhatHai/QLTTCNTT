package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "receipt_code", nullable = false)
    private String receiptCode;

    @NotNull
    @Column(name = "date_add", nullable = false)
    private String dateAdd;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "price")
    private Long price;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

//    @ManyToOne(fetch = FetchType.EAGER )
//    @JoinColumn(name = "equipment_type_id", nullable = false)
//    private EquipmentType equipmentType;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    public Receipt(Long id, String receiptCode, String dateAdd, Long quantity, Long price, String description, Employee employee, Vendor vendor, Warehouse warehouse, EquipmentType equipmentType, List<Equipment> equipments) {
        this.id = id;
        this.receiptCode = receiptCode;
        this.dateAdd = dateAdd;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.employee = employee;
        this.vendor = vendor;
        this.warehouse = warehouse;
        this.equipments = equipments;
    }

    public Receipt() {
    }

    public @NotNull String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(@NotNull String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public @NotNull Long getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}