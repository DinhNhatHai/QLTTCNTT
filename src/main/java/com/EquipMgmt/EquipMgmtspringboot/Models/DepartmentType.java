package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "department_type")
public class DepartmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "department_type_name", nullable = false)
    private String NameDepartmentType;

    @NotNull
    @Column(name = "show_home", nullable = false)
    private String showHome;

    public DepartmentType(){

    }

    public DepartmentType(Long id, String typeName, String showHome) {
        this.id = id;
        this.NameDepartmentType = typeName;
        this.showHome = showHome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDepartmentType() {
        return NameDepartmentType;
    }

    public void setNameDepartmentType(String NameDepartmentType) {
        this.NameDepartmentType = NameDepartmentType;
    }
    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }
}
