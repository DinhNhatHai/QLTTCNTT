package com.EquipMgmt.EquipMgmtspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
