package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import com.EquipMgmt.EquipMgmtspringboot.Models.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> findAll();
    Optional<Role> getRoleById(Long id);
    void save(Role employee);
    void deleteById(Long id);
}
