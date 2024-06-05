package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "name", length = 50)
    private String nameSubCategory;

    @Column(name = "show_home")
    private Boolean showHome;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.EAGER)
    private List<Equipment> equipments;

    public SubCategory(){
    }

    public SubCategory(Long id, String nameSubCategory, Boolean showHome, Category category, List<Equipment> equipments) {
        this.id = id;
        this.nameSubCategory = nameSubCategory;
        this.showHome = showHome;
        this.category = category;
        this.equipments = equipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 2, max = 50) String getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(@Size(min = 2, max = 50) String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public Boolean getShowHome() {
        return showHome;
    }

    public void setShowHome(Boolean showHome) {
        this.showHome = showHome;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
