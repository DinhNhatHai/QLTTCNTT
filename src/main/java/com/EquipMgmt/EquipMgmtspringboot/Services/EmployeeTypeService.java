package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeTypeService {
    List<EmployeeType> findAll();
    Optional<EmployeeType> getEmployeeTypeById(Long id);
    void save(EmployeeType employeeType);
    void deleteById(Long id);
}
