package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepairTicketRepository extends JpaRepository<EquipmentRepairTicket, Long> {
    @Query("SELECT b FROM EquipmentRepairTicket b WHERE b.equipmentRepairTicketId LIKE %?1%")
    List<EquipmentRepairTicket> search(String keyword);
}
