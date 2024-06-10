package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "status_type")
public class StatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 5, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String nameStatusType;
    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;
    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private  String description;
//    @OneToMany(mappedBy = "statusType")
//    private Set <StatusType> statusTypes;


}
