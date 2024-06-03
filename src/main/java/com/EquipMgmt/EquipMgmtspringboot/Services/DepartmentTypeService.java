package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentTypeService {
    List<DepartmentType> getAllDepartmentTypes();
    DepartmentType getCategoryDepartmentById(Long id);
    DepartmentType updateDepartmentType(DepartmentType departmentType);
    void  deleteCategoryDepartment(Long id);
}
