package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.DepartmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentTypeServiceImpl implements DepartmentTypeService {

    @Autowired
    private DepartmentTypeRepository departmentTypeRepository;

    public List<DepartmentType> getAllDepartmentTypes() {
        return departmentTypeRepository.findAll();
    }

    public DepartmentType getCategoryDepartmentById(Long id) {
        return departmentTypeRepository.findById(id).orElse(null);
    }

    public DepartmentType updateDepartmentType(DepartmentType departmentType) {
        return departmentTypeRepository.save(departmentType);
    }

    public void deleteCategoryDepartment(Long id) {
        departmentTypeRepository.deleteById(id);
    }

}
