package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicketType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ReplacementUpgradeTicketTypeService {
    List< ReplacementUpgradeTicketType> findAll();
    Optional< ReplacementUpgradeTicketType> getReplacementUpgradeTicketTypeById(Long id);
    void save( ReplacementUpgradeTicketType replacementUpgradeTicketType);
    void deleteById(Long id);
}