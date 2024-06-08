package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "delivery_bill")
public class DeliveryBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "delivery_bill_id", nullable = false)
    private String deliveryBillId;

    @Column(name = "send_date", nullable = false)
    private String sendDate;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "equipment_type_id", nullable = false)
    private EquipmentType equipmentType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", nullable = false)
    private Equipment equipment;

    public DeliveryBill() {
    }

    public DeliveryBill(Long id, String deliveryBillId, String sendDate, Long quantity, String description, Employee employee, Department department, Warehouse warehouse, EquipmentType equipmentType, Equipment equipment) {
        this.id = id;
        this.deliveryBillId = deliveryBillId;
        this.sendDate = sendDate;
        this.quantity = quantity;
        this.description = description;
        this.employee = employee;
        this.department = department;
        this.warehouse = warehouse;
        this.equipmentType = equipmentType;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryBillId() {
        return deliveryBillId;
    }

    public void setDeliveryBillId(String deliveryBillId) {
        this.deliveryBillId = deliveryBillId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public @NotNull Long getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull Long quantity) {
        this.quantity = quantity;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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
}