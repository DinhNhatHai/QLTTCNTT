package com.EquipMgmt.EquipMgmtspringboot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @NotBlank
    @Size(min = 10, max = 15, message = "Số điện thoại phải có ít nhất 10 và không quá 15 ký tự")
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @NotBlank
    @Email(message = "Email không đúng định dạng")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(max = 100)
    @Column(name = "address", nullable = false)
    private String address;

    @Size(max = 255, message = "Mô tả không được dài hơn 255 ký tự")
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER)
    private List<Guarantee> guarantees;

    public Vendor() {
    }

    public Vendor(Long id, String vendorName, String telephone, String email, String address, String description, List<Guarantee> guarantees) {
        this.id = id;
        this.vendorName = vendorName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.description = description;
        this.guarantees = guarantees;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Guarantee> getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(List<Guarantee> guarantees) {
        this.guarantees = guarantees;
    }
}
