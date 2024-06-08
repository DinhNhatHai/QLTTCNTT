package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentRepairTicketService {
    List<EquipmentRepairTicket> getAll();
    Boolean create(EquipmentRepairTicket equipmentRepairTicket);
    EquipmentRepairTicket findById(Long id);
    Boolean update(EquipmentRepairTicket equipmentRepairTicket);
    Boolean delete(Long id);
    List<EquipmentRepairTicket> search(String keyword);
}
