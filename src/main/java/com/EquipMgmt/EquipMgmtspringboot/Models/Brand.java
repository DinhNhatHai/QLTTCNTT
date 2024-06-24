package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 1, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String nameBrand;

    @Column(name = "show_home", nullable = false)
    private boolean showHome;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<Equipment> equipments;


    public Brand() {
    }

    public Brand(Long id, String nameBrand, boolean showHome, List<Equipment> equipments) {
        this.id = id;
        this.nameBrand = nameBrand;
        this.showHome = showHome;
        this.equipments = equipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 1, max = 50) String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(@Size(min = 1, max = 50) String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public boolean isShowHome() {
        return showHome;
    }

    public void setShowHome(boolean showHome) {
        this.showHome = showHome;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }
    public void setEquipment(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
