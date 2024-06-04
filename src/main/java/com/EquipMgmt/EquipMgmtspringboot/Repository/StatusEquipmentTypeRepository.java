package com.EquipMgmt.EquipMgmtspringboot.Repository;


import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEquipmentTypeRepository extends JpaRepository<StatusEquipmentType, Long> {
}
