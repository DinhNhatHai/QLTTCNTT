package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.DepartmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentTypeServiceImpl implements DepartmentTypeService {

    @Autowired
    private DepartmentTypeRepository departmentTypeRepository;

    @Override
    public List<DepartmentType> findAll() {
        return departmentTypeRepository.findAll();
    }

    @Override
    public void save(DepartmentType departmentType) {
        departmentTypeRepository.save(departmentType);
    }

    @Override
    public void deleteById(Long id) {
        departmentTypeRepository.deleteById(id);
    }

    @Override
    public Optional<DepartmentType> getDepartmentTypeById(Long id) {
        return departmentTypeRepository.findById(id);
    }
}
