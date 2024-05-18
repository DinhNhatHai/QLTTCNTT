package com.EquipMgmt.EquipMgmtspringboot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Size(min = 10, max =15,message = "Phone number must be between 10 and 15 characters" )
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    public Supplier(Long id, String supplierName, String phoneNumber, String email, String address) {
        this.id = id;
        this.supplierName = supplierName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
