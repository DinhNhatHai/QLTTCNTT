package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicketType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReplacementUpgradeTicketRepository;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReplacementUpgradeTicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplacementUpgradeTicketTypeServiceImpl implements ReplacementUpgradeTicketTypeService {

    @Autowired
    private ReplacementUpgradeTicketTypeRepository replacementUpgradeTicketTypeRepository;

    @Override
    public List<ReplacementUpgradeTicketType> findAll() {
        return replacementUpgradeTicketTypeRepository.findAll();
    }

    @Override
    public Optional<ReplacementUpgradeTicketType> getReplacementUpgradeTicketTypeById(Long id) {
        return replacementUpgradeTicketTypeRepository.findById(id);
    }

    @Override
    public void save(ReplacementUpgradeTicketType replacementUpgradeTicketType) {
        replacementUpgradeTicketTypeRepository.save(replacementUpgradeTicketType);
    }

    @Override
    public void deleteById(Long id) {
        replacementUpgradeTicketTypeRepository.deleteById(id);
    }
}
