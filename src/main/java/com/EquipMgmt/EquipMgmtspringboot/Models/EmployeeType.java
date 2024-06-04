package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee_type")
public class EmployeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50, message = "Employee type name must be between 3 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String nameEmployeeType;

    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "employeeType", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public EmployeeType() {
    }

    public EmployeeType(Long id, String nameEmployeeType, String showHome, String description, List<Employee> employees) {
        this.id = id;
        this.nameEmployeeType = nameEmployeeType;
        this.showHome = showHome;
        this.description = description;
        this.employees = employees;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNameEmployeeType() {
        return nameEmployeeType;
    }

    public void setNameEmployeeType(String nameEmployeeType) {
        this.nameEmployeeType = nameEmployeeType;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getEmployeeTypeId() {
        return id;
    }

    public void setEmployeeTypeId(Long id) {
        this.id = id;
    }
}
