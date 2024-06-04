package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
