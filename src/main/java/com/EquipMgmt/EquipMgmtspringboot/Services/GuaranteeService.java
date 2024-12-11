package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Guarantee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface GuaranteeService {
    List<Guarantee> findAll();
    Optional<Guarantee> getGuaranteeById(Long id);
    void save(Guarantee guarantee);
    void deleteById(Long id);
}