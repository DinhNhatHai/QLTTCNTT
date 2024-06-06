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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "replacement_upgrade_ticket_id", nullable = false)
    private ReplacementUpgradeTicketType replacementUpgradeTicketType;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "original_equipment_type_id", nullable = false)
    private EquipmentType originalEquipmentTypeId;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "new_equipment_type_id", nullable = false)
    private EquipmentType newEquipmentTypeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "original_equipment_id", nullable = false)
    private Equipment originalEquipmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "new_equipment_id", nullable = false)
    private Equipment newEquipmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public ReplacementUpgradeTicket() {
    }

    public ReplacementUpgradeTicket(Long id, String receivedDate, String actionDate, String description, ReplacementUpgradeTicketType replacementUpgradeTicketType, EquipmentType originalEquipmentTypeId, EquipmentType newEquipmentTypeId, Equipment originalEquipmentId, Equipment newEquipmentId, Employee employee) {
        this.id = id;
        this.receivedDate = receivedDate;
        this.actionDate = actionDate;
        this.description = description;
        this.replacementUpgradeTicketType = replacementUpgradeTicketType;
        this.originalEquipmentTypeId = originalEquipmentTypeId;
        this.newEquipmentTypeId = newEquipmentTypeId;
        this.originalEquipmentId = originalEquipmentId;
        this.newEquipmentId = newEquipmentId;
        this.employee = employee;
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

    public ReplacementUpgradeTicketType getReplacementUpgradeTicketType() {
        return replacementUpgradeTicketType;
    }

    public void setReplacementUpgradeTicketType(ReplacementUpgradeTicketType replacementUpgradeTicketType) {
        this.replacementUpgradeTicketType = replacementUpgradeTicketType;
    }

    public EquipmentType getOriginalEquipmentTypeId() {
        return originalEquipmentTypeId;
    }

    public void setOriginalEquipmentTypeId(EquipmentType originalEquipmentTypeId) {
        this.originalEquipmentTypeId = originalEquipmentTypeId;
    }

    public EquipmentType getNewEquipmentTypeId() {
        return newEquipmentTypeId;
    }

    public void setNewEquipmentTypeId(EquipmentType newEquipmentTypeId) {
        this.newEquipmentTypeId = newEquipmentTypeId;
    }

    public Equipment getOriginalEquipmentId() {
        return originalEquipmentId;
    }

    public void setOriginalEquipmentId(Equipment originalEquipmentId) {
        this.originalEquipmentId = originalEquipmentId;
    }

    public Equipment getNewEquipmentId() {
        return newEquipmentId;
    }

    public void setNewEquipmentId(Equipment newEquipmentId) {
        this.newEquipmentId = newEquipmentId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}