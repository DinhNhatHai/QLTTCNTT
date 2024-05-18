package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.User;

public interface UserService {
    User findByUsername(String userName);
}
