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
    private List<Device> devices;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public boolean isShowHome() {
        return showHome;
    }

    public void setShowHome(boolean showHome) {
        this.showHome = showHome;
    }
}
