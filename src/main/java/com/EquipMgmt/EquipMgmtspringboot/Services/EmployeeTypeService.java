package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeTypeService {
    List<EmployeeType> findAll();
    Optional<EmployeeType> getEmployeeTypeById(Long id);
    void save(EmployeeType employeeType);
    void deleteById(Long id);
}
