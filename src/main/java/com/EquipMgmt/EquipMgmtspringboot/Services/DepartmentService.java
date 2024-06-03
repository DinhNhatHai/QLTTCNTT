package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department saveDepartment(Department department);
    void deleteDepartment(Long id);
}
