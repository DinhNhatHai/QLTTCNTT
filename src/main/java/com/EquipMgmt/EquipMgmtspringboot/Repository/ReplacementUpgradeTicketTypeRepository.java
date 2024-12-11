package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementUpgradeTicketTypeRepository extends JpaRepository<ReplacementUpgradeTicketType, Long> {
}
