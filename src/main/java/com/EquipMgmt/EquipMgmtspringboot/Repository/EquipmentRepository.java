package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
