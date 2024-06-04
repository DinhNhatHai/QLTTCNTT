package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.UserSubRoles;
import com.EquipMgmt.EquipMgmtspringboot.Repository.UserSubRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSubRoleServiceImpl implements UserSubRoleService {

    @Autowired
    private UserSubRoleRepository userSubRoleRepository;

    @Override
    public List<UserSubRoles> findAll() {
        return userSubRoleRepository.findAll();
    }

    @Override
    public Optional<UserSubRoles> getUserSubRoleById(Long id) {
        return userSubRoleRepository.findById(id);
    }

    @Override
    public void save(UserSubRoles userSubRoles) {
        userSubRoleRepository.save(userSubRoles);
    }

    @Override
    public void deleteById(Long id) {
        userSubRoleRepository.deleteById(id);
    }
}
