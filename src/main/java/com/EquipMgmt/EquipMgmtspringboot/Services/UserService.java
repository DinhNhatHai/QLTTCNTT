package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User findByUsername(String userName);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
    Optional<User> getId(Long id);
}
