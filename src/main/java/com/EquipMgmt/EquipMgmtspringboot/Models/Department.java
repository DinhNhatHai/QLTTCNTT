package com.EquipMgmt.EquipMgmtspringboot.Models;


import jakarta.persistence.*;
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


}


