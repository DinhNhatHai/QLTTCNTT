package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import com.EquipMgmt.EquipMgmtspringboot.Models.Vendor;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> findAll() {
        return employeeTypeRepository.findAll();
    }

    @Override
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    @Override
    public void deleteById(Long id) {
        employeeTypeRepository.deleteById(id);
    }

    @Override
    public Optional<EmployeeType> getEmployeeTypeById(Long id) {
        return employeeTypeRepository.findById(id);
    }

}
