package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_type_id", referencedColumnName = "id", nullable = false)
    private EmployeeType employeeType;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_code", nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "address")
    private String address;

    public Employee() {
    }

    public Employee(Long id, EmployeeType employeeType, User user, String name, String employeeCode, String email, String telephone, String address) {
        this.id = id;
        this.employeeType = employeeType;
        this.user = user;
        this.name = name;
        this.employeeCode = employeeCode;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
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
}