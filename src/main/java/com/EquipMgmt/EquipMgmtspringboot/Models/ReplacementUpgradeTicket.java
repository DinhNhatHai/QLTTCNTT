package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "replacement_upgrade_ticket")
public class ReplacementUpgradeTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "received_date", nullable = false)
    private String receivedDate;

    @Column(name = "action_date", nullable = false)
    private String actionDate;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @Column(name = "location_outside")
    private String nameLocationOutside;

    @Column(name = "original_equipment_name")
    private String nameOriginalEquipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "replacement_upgrade_ticket_type_id", nullable = false)
    private ReplacementUpgradeTicketType replacementUpgradeTicketType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "original_equipment_type_id", nullable = false)
    private EquipmentType originalEquipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "new_equipment_type_id", nullable = false)
    private EquipmentType newEquipmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "original_equipment_id", nullable = false)
    private Equipment originalEquipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "new_equipment_id", nullable = false)
    private Equipment newEquipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_name", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public ReplacementUpgradeTicket() {
    }

    public ReplacementUpgradeTicket(Long id, String receivedDate, String actionDate, String description, String nameLocationOutside, String nameOriginalEquipment, ReplacementUpgradeTicketType replacementUpgradeTicketType, EquipmentType originalEquipmentType, EquipmentType newEquipmentType, Equipment originalEquipment, Equipment newEquipment, Employee employee, Department department) {
        this.id = id;
        this.receivedDate = receivedDate;
        this.actionDate = actionDate;
        this.description = description;
        this.nameLocationOutside = nameLocationOutside;
        this.nameOriginalEquipment = nameOriginalEquipment;
        this.replacementUpgradeTicketType = replacementUpgradeTicketType;
        this.originalEquipmentType = originalEquipmentType;
        this.newEquipmentType = newEquipmentType;
        this.originalEquipment = originalEquipment;
        this.newEquipment = newEquipment;
        this.employee = employee;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public @Size(max = 255, message = "Description must be less than 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be less than 255 characters") String description) {
        this.description = description;
    }

    public String getNameOriginalEquipment() {
        return nameOriginalEquipment;
    }

    public void setNameOriginalEquipment(String nameOriginalEquipment) {
        this.nameOriginalEquipment = nameOriginalEquipment;
    }

    public ReplacementUpgradeTicketType getReplacementUpgradeTicketType() {
        return replacementUpgradeTicketType;
    }

    public void setReplacementUpgradeTicketType(ReplacementUpgradeTicketType replacementUpgradeTicketType) {
        this.replacementUpgradeTicketType = replacementUpgradeTicketType;
    }

    public EquipmentType getOriginalEquipmentType() {
        return originalEquipmentType;
    }

    public void setOriginalEquipmentType(EquipmentType originalEquipmentType) {
        this.originalEquipmentType = originalEquipmentType;
    }

    public EquipmentType getNewEquipmentType() {
        return newEquipmentType;
    }

    public void setNewEquipmentType(EquipmentType newEquipmentType) {
        this.newEquipmentType = newEquipmentType;
    }

    public Equipment getOriginalEquipment() {
        return originalEquipment;
    }

    public void setOriginalEquipment(Equipment originalEquipment) {
        this.originalEquipment = originalEquipment;
    }

    public Equipment getNewEquipment() {
        return newEquipment;
    }

    public void setNewEquipment(Equipment newEquipment) {
        this.newEquipment = newEquipment;
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

    public String getNameLocationOutside() {
        return nameLocationOutside;
    }

    public void setNameLocationOutside(String nameLocationOutside) {
        this.nameLocationOutside = nameLocationOutside;
    }
}