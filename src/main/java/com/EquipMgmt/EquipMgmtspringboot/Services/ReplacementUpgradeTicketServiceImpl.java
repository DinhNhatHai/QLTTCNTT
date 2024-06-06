package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicket;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReplacementUpgradeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplacementUpgradeTicketServiceImpl implements ReplacementUpgradeTicketService {

    @Autowired
    private ReplacementUpgradeTicketRepository replacementUpgradeTicketRepository;

    @Override
    public List<ReplacementUpgradeTicket> findAll() {
        return replacementUpgradeTicketRepository.findAll();
    }

    @Override
    public Optional<ReplacementUpgradeTicket> getReplacementUpgradeTicketById(Long id) {
        return replacementUpgradeTicketRepository.findById(id);
    }

    @Override
    public void save(ReplacementUpgradeTicket replacementUpgradeTicket) {
        replacementUpgradeTicketRepository.save(replacementUpgradeTicket);
    }

    @Override
    public void deleteById(Long id) {
        replacementUpgradeTicketRepository.deleteById(id);
    }
}
