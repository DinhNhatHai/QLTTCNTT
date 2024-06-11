package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "department_type_id", nullable = false)
    private DepartmentType departmentType;

    @Size(min = 3, max = 50)
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "location", nullable = false)
    private String location;

    @NotNull
    @Column(name = "show_home", nullable = false)
    private Boolean showHome;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<ReplacementUpgradeTicket> replacementUpgradeTickets;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<ReplacementRepairTicket> replacementRepairTickets;


    public Department(){

    }

    public Department(Long id, DepartmentType departmentType, String departmentName, String location, Boolean showHome, List<ReplacementUpgradeTicket> replacementUpgradeTickets, List<ReplacementRepairTicket> replacementRepairTickets) {
        this.id = id;
        this.departmentType = departmentType;
        this.departmentName = departmentName;
        this.location = location;
        this.showHome = showHome;
        this.replacementUpgradeTickets = replacementUpgradeTickets;
        this.replacementRepairTickets = replacementRepairTickets;
    }

    public List<ReplacementRepairTicket> getReplacementRepairTickets() {
        return replacementRepairTickets;
    }

    public void setReplacementRepairTickets(List<ReplacementRepairTicket> replacementRepairTickets) {
        this.replacementRepairTickets = replacementRepairTickets;
    }

    public Boolean getShowHome() {
        return showHome;
    }

    public void setShowHome(Boolean showHome) {
        this.showHome = showHome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ReplacementUpgradeTicket> getReplacementUpgradeTickets() {
        return replacementUpgradeTickets;
    }

    public void setReplacementUpgradeTickets(List<ReplacementUpgradeTicket> replacementUpgradeTickets) {
        this.replacementUpgradeTickets = replacementUpgradeTickets;
    }
}


