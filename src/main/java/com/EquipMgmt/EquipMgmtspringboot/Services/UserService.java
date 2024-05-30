package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUsername(String userName);
}
