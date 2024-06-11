package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReplacementRepairTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplacementRepairTicketServiceImpl implements ReplacementRepairTicketService{
    @Autowired
    private ReplacementRepairTicketRepository replacementRepairTicketRepository;
    @Override
    public List<ReplacementRepairTicket> getAll() {
        return this.replacementRepairTicketRepository.findAll();
    }

    @Override
    public Boolean create(ReplacementRepairTicket replacementRepairTicket) {
        try {
            this.replacementRepairTicketRepository.save(replacementRepairTicket);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public ReplacementRepairTicket findById(Long id) {
        return this.replacementRepairTicketRepository.findById(id).get();
    }

    @Override
    public Boolean update(ReplacementRepairTicket replacementRepairTicket) {
        try{
            this.replacementRepairTicketRepository.save(replacementRepairTicket);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.replacementRepairTicketRepository.delete(findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ReplacementRepairTicket> search(String keyword) {
        return replacementRepairTicketRepository.search(keyword);
    }
}
