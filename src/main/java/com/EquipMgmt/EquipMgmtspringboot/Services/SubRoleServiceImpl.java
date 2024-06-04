package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubRole;
import com.EquipMgmt.EquipMgmtspringboot.Repository.SubRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubRoleServiceImpl implements SubRoleService {

    @Autowired
    private SubRoleRepository subRoleRepository;

    @Override
    public List<SubRole> findAll() {
        return subRoleRepository.findAll();
    }

    @Override
    public Optional<SubRole> getSubRoleById(Long id) {
        return subRoleRepository.findById(id);
    }

    @Override
    public void save(SubRole subRole) {
        subRoleRepository.save(subRole);
    }

    @Override
    public void deleteById(Long id) {
        subRoleRepository.deleteById(id);
    }
}
