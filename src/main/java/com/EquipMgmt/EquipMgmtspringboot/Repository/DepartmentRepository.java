package com.EquipMgmt.EquipMgmtspringboot.Repository;


import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
