package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRoleRepository extends JpaRepository<SubRole, Long> {
}
