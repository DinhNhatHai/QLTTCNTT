package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Services.DepartmentService;
import com.EquipMgmt.EquipMgmtspringboot.Services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/department-equipment")
public class DepartmentEquipmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EquipmentService equipmentService;
    @GetMapping
    public String getDepartments(@RequestParam(required = false) Long departmentId, Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        if (departmentId != null) {
            Department selectedDepartment = departmentService.getDepartmentById(departmentId);
            List<Equipment> equipments = equipmentService.findByDepartmentId(departmentId);
            model.addAttribute("selectedDepartment", selectedDepartment);
            model.addAttribute("equipments", equipments);
        }

        return "admin/department_equipment/list";
    }
}
