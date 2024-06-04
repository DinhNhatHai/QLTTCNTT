package com.EquipMgmt.EquipMgmtspringboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import com.EquipMgmt.EquipMgmtspringboot.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplement(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getId(Long id) {
        return userRepository.findById(id);
    }
}

