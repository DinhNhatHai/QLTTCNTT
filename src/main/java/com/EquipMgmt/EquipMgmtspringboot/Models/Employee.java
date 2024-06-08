package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeType employeeType;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "employee_code", nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<ReplacementUpgradeTicket> replacementUpgradeTickets;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Warranty> warranties;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Receipt> receipts;

    public Employee() {
    }

    public Employee(Long id, EmployeeType employeeType, User user, String name, String employeeCode, String email, String telephone, String address, List<ReplacementUpgradeTicket> replacementUpgradeTickets, List<Warranty> warranties, List<Receipt> receipts) {
        this.id = id;
        this.employeeType = employeeType;
        this.user = user;
        this.name = name;
        this.employeeCode = employeeCode;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.replacementUpgradeTickets = replacementUpgradeTickets;
        this.warranties = warranties;
        this.receipts = receipts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ReplacementUpgradeTicket> getReplacementUpgradeTickets() {
        return replacementUpgradeTickets;
    }

    public void setReplacementUpgradeTickets(List<ReplacementUpgradeTicket> replacementUpgradeTickets) {
        this.replacementUpgradeTickets = replacementUpgradeTickets;
    }

    public List<Warranty> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<Warranty> warranties) {
        this.warranties = warranties;
    }
    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}