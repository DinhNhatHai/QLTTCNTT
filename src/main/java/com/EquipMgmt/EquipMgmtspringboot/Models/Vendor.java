package com.EquipMgmt.EquipMgmtspringboot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @Size(min = 10, max =15,message = "Phone number must be between 10 and 15 characters" )
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    public Vendor(Long id, String vendorName, String telephone, String email, String address) {
        this.id = id;
        this.vendorName = vendorName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
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

    public String getPhoneNumber() {
        return telephone;
    }

    public void setPhoneNumber(String telephone) {
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
}
