package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "replacement_upgrade_ticket_type")
public class ReplacementUpgradeTicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50, message = "Employee type name must be between 3 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String nameReplacementUpgradeTicketType;

    @NotBlank
    @Column(name = "show_home", nullable = false)
    private String showHome;

    @OneToMany(mappedBy = "replacementUpgradeTicketType", fetch = FetchType.EAGER)
    private List<ReplacementUpgradeTicket> replacementUpgradeTickets;

    public ReplacementUpgradeTicketType() {
    }

    public ReplacementUpgradeTicketType(Long id, String nameReplacementUpgradeTicketType, String showHome, List<ReplacementUpgradeTicket> replacementUpgradeTickets) {
        this.id = id;
        this.nameReplacementUpgradeTicketType = nameReplacementUpgradeTicketType;
        this.showHome = showHome;
        this.replacementUpgradeTickets = replacementUpgradeTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50, message = "Employee type name must be between 3 and 50 characters") String getNameReplacementUpgradeTicketType() {
        return nameReplacementUpgradeTicketType;
    }

    public void setNameReplacementUpgradeTicketType(@Size(min = 3, max = 50, message = "Employee type name must be between 3 and 50 characters") String nameReplacementUpgradeTicketType) {
        this.nameReplacementUpgradeTicketType = nameReplacementUpgradeTicketType;
    }

    public @NotBlank String getShowHome() {
        return showHome;
    }

    public void setShowHome(@NotBlank String showHome) {
        this.showHome = showHome;
    }

    public List<ReplacementUpgradeTicket> getReplacementUpgradeTickets() {
        return replacementUpgradeTickets;
    }

    public void setReplacementUpgradeTickets(List<ReplacementUpgradeTicket> replacementUpgradeTickets) {
        this.replacementUpgradeTickets = replacementUpgradeTickets;
    }
}