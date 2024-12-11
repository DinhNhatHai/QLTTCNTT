package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3 , max = 50)
    @Column(name = "name", length = 50)
    private String nameCategory;

    @Column(name = "show_home")
    private Boolean showHome;

    @Column(name = "image")
    private String image;

    @Column(name ="description ")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<EquipmentType> equipmentTypes;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Equipment> equipments;

    public Category(Long id, String nameCategory, Boolean showHome, String image, String description, Set<EquipmentType> equipmentTypes, List<Equipment> equipments) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.showHome = showHome;
        this.image = image;
        this.description = description;
        this.equipmentTypes = equipmentTypes;
        this.equipments = equipments;
    }

    public Category(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50) String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(@Size(min = 3, max = 50) String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Boolean getShowHome() {
        return showHome;
    }

    public void setShowHome(Boolean showHome) {
        this.showHome = showHome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EquipmentType> getEquipmentTypes() {
        return equipmentTypes;
    }

    public void setEquipmentTypes(Set<EquipmentType> equipmentTypes) {
        this.equipmentTypes = equipmentTypes;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
