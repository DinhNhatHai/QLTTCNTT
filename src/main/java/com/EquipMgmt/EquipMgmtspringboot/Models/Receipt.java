package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "receipt_id", nullable = false)
    private String receiptId;

    @Column(name = "date_time", nullable = false)
    private String dateTime;

    @Column(name = "name_receipt", nullable = false)
    private String nameReceipt;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Long price;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;


    public Receipt() {
    }

}