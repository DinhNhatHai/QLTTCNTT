package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Guarantee;
import com.EquipMgmt.EquipMgmtspringboot.Repository.GuaranteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    private GuaranteeRepository guaranteeRepository;

    @Override
    public List<Guarantee> findAll() {
        return guaranteeRepository.findAll();
    }

    @Override
    public Optional<Guarantee> getGuaranteeById(Long id) {
        return guaranteeRepository.findById(id);
    }

    @Override
    public void save(Guarantee guarantee) {
        guaranteeRepository.save(guarantee);
    }

    @Override
    public void deleteById(Long id) {
        guaranteeRepository.deleteById(id);
    }
}
