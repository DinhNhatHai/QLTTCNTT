package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementUpgradeTicketRepository extends JpaRepository<ReplacementUpgradeTicket, Long> {
}
