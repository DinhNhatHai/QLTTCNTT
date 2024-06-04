package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.UserSubRoles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserSubRoleService {
    List<UserSubRoles> findAll();
    Optional<UserSubRoles> getUserSubRoleById(Long id);
    void save(UserSubRoles userSubRoles);
    void deleteById(Long id);
}
