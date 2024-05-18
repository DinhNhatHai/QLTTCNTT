package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 5, max = 50)
    @Column(name = "name")
    private String nameStatus;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_type",referencedColumnName = "id", nullable = false)
    private StatusType statusType;
}
