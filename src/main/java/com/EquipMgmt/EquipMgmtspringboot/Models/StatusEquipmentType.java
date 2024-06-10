package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;
@Entity
@Table(name = "status_equipment_type")
public class StatusEquipmentType {
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
        private String description;
//        @OneToMany(mappedBy = "statusEquipmentType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//        private Set<StatusEquipmentType> statusEquipmentTypes;
//        public StatusEquipmentType() {
//        }
//
//    public StatusEquipmentType(String nameStatusType, String showHome, String description) {
//        this.nameStatusType = nameStatusType;
//        this.showHome = showHome;
//        this.description = description;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStatusType() {
        return nameStatusType;
    }

    public void setNameStatusType(String nameStatusType) {
        this.nameStatusType = nameStatusType;
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

//    public Set<StatusEquipmentType> getStatusEquipmentTypes() {
//        return statusEquipmentTypes;
//    }
//
//    public void setStatusEquipmentTypes(Set<StatusEquipmentType> statusEquipmentTypes) {
//        this.statusEquipmentTypes = statusEquipmentTypes;
//    }
}

