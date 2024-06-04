package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentTypeService {
    List<DepartmentType> findAll();
    Optional<DepartmentType> getDepartmentTypeById(Long id);
    void save(DepartmentType departmentType);
    void deleteById(Long id);
}
