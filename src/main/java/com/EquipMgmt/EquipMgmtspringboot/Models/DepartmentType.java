package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "department_type")
public class DepartmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "department_type_name", nullable = false)
    private String nameDepartmentType;

    @NotNull
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @OneToMany(mappedBy = "departmentType", fetch = FetchType.EAGER)
    private List<Department> departments;

    public DepartmentType(){

    }

    public DepartmentType(Long id, String nameDepartmentType, String showHome, List<Department> departments) {
        this.id = id;
        this.nameDepartmentType = nameDepartmentType;
        this.showHome = showHome;
        this.departments = departments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50) String getNameDepartmentType() {
        return nameDepartmentType;
    }

    public void setNameDepartmentType(@Size(min = 3, max = 50) String nameDepartmentType) {
        this.nameDepartmentType = nameDepartmentType;
    }

    public @NotNull String getShowHome() {
        return showHome;
    }

    public void setShowHome(@NotNull String showHome) {
        this.showHome = showHome;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
