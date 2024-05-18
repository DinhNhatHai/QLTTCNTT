package com.EquipMgmt.EquipMgmtspringboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import com.EquipMgmt.EquipMgmtspringboot.Repository.UserRepository;

import java.util.Set;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}
