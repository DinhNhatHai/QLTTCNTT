package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_type_id",referencedColumnName = "id", nullable = false)
    private DepartmentType departmentType;

    @Size(min = 3, max = 50)
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "location", nullable = false)
    private String location;

    @NotNull
    @Column(name = "show_home", nullable = false)
    private Boolean showHome;


    public Boolean getShowHome() {
        return showHome;
    }

    public void setShowHome(Boolean showHome) {
        this.showHome = showHome;
    }

    public Department(){

    }

    public Department(Long id, DepartmentType departmentType, String departmentName, String location, Boolean showHome) {
        this.id = id;
        this.departmentType = departmentType;
        this.departmentName = departmentName;
        this.location = location;
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


}


