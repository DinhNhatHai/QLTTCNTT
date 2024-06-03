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
    private String typeName;

    @NotNull
    @Column(name = "show_home", nullable = false)
    private String showHome;

    public DepartmentType(){

    }

    public DepartmentType(Long id, String typeName, String showHome) {
        this.id = id;
        this.typeName = typeName;
        this.showHome = showHome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }
}
