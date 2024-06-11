package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementRepairTicket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplacementRepairTicketService {
    List<ReplacementRepairTicket> getAll();
    Boolean create(ReplacementRepairTicket replacementRepairTicket);
    ReplacementRepairTicket findById(Long id);
    Boolean update(ReplacementRepairTicket replacementRepairTicket);
    Boolean delete(Long id);
    List<ReplacementRepairTicket> search(String keyword);
}
