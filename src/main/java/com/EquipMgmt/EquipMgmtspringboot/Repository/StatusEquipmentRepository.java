package com.EquipMgmt.EquipMgmtspringboot.Repository;


import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEquipmentRepository extends JpaRepository<StatusEquipment, Long> {
}
