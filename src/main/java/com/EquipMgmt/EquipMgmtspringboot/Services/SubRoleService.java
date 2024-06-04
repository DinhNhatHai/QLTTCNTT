package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubRoleService {
    List<SubRole> findAll();
    Optional<SubRole> getSubRoleById(Long id);
    void save(SubRole employee);
    void deleteById(Long id);
}
