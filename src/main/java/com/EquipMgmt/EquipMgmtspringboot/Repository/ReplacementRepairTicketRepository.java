package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementRepairTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplacementRepairTicketRepository extends JpaRepository<ReplacementRepairTicket, Long> {
    @Query("SELECT b FROM ReplacementRepairTicket b WHERE b.replaceRepairTicketId LIKE %?1%")
    List<ReplacementRepairTicket> search(String keyword);
}
