package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models. ReplacementUpgradeTicket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ReplacementUpgradeTicketService {
    List< ReplacementUpgradeTicket> findAll();
    Optional< ReplacementUpgradeTicket> getReplacementUpgradeTicketById(Long id);
    void save( ReplacementUpgradeTicket replacementUpgradeTicket);
    void deleteById(Long id);
}