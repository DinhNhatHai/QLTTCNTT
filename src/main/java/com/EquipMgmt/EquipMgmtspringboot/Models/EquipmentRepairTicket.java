package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment_repair_ticket")
public class EquipmentRepairTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "equipment_repair_ticket_id")
    private String equipmentRepairTicketId;

    @Column(name = "received_date")
    private String receivedDate;

    @Column(name = "processing_time")
    private String processingTime;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "repair_place")
    private String repairPlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_type_id", nullable = false)
    private EquipmentType equipmentType;

    public EquipmentRepairTicket(){

    }

    public EquipmentRepairTicket(Long id, String equipmentRepairTicketId, String receivedDate, String processingTime, String description, String comment, String repairPlace, Employee employee, Equipment equipment, Department department, EquipmentType equipmentType) {
        this.id = id;
        this.equipmentRepairTicketId = equipmentRepairTicketId;
        this.receivedDate = receivedDate;
        this.processingTime = processingTime;
        this.description = description;
        this.comment = comment;
        this.repairPlace = repairPlace;
        this.employee = employee;
        this.equipment = equipment;
        this.department = department;
        this.equipmentType = equipmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentRepairTicketId() {
        return equipmentRepairTicketId;
    }

    public void setEquipmentRepairTicketId(String equipmentRepairTicketId) {
        this.equipmentRepairTicketId = equipmentRepairTicketId;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRepairPlace() {
        return repairPlace;
    }

    public void setRepairPlace(String repairPlace) {
        this.repairPlace = repairPlace;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }


}
