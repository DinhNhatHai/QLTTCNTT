package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    List<Department> findAll();
    Optional<Department> getDepartmentById(Long id);
    void save(Department department);
    void deleteById(Long id);
}
