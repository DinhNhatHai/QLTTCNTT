package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentRepairTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentRepairTicketServiceImpl implements EquipmentRepairTicketService{
    @Autowired
    private EquipmentRepairTicketRepository equipmentRepairTicketRepository;
    @Override
    public List<EquipmentRepairTicket> getAll() {
        return this.equipmentRepairTicketRepository.findAll();
    }

    @Override
    public Boolean create(EquipmentRepairTicket equipmentRepairTicket) {
        try {
            this.equipmentRepairTicketRepository.save(equipmentRepairTicket);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public EquipmentRepairTicket findById(Long id) {
        return this.equipmentRepairTicketRepository.findById(id).get();
    }

    @Override
    public Boolean update(EquipmentRepairTicket replacementRepairTicket) {
        try{
            this.equipmentRepairTicketRepository.save(replacementRepairTicket);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.equipmentRepairTicketRepository.delete(findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<EquipmentRepairTicket> search(String keyword) {
        return equipmentRepairTicketRepository.search(keyword);
    }
}
