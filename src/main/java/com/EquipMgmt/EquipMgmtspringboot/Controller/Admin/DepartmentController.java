package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import com.EquipMgmt.EquipMgmtspringboot.Services.DepartmentService;
import com.EquipMgmt.EquipMgmtspringboot.Services.DepartmentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentTypeService departmentTypeService;

    @GetMapping
    public String getAllDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "admin/department/list";
    }

    @GetMapping("/create")
    public String createDepartmentForm(Model model) {
        List<DepartmentType> departmentTypes = departmentTypeService.getAllDepartmentTypes();
        model.addAttribute("departmentTypes", departmentTypes);
        model.addAttribute("department", new Department());
        model.addAttribute("showHomeOptions", getShowHomeOptions());
        return "admin/department/create";
    }

    @PostMapping("/create")
    public String createDepartment(@ModelAttribute("department") Department department) {
        DepartmentType departmentType = departmentTypeService.getCategoryDepartmentById(department.getDepartmentType().getId());
        department.setDepartmentType(departmentType);
        departmentService.saveDepartment(department);
        return "redirect:/admin/department";
    }

    @GetMapping("/edit/{id}")
    public String editDepartmentForm(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        List<DepartmentType> departmentTypes = departmentTypeService.getAllDepartmentTypes();
        if (department != null) {
            model.addAttribute("department", department);
            model.addAttribute("departmentTypes", departmentTypes);
            model.addAttribute("showHomeOptions", getShowHomeOptions());
            return "admin/department/edit";
        } else {
            return "redirect:/admin/department";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateDepartment(@PathVariable Long id, @Valid @ModelAttribute("department") Department departmentDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<DepartmentType> departmentTypes = departmentTypeService.getAllDepartmentTypes();
            model.addAttribute("departmentTypes", departmentTypes);
            model.addAttribute("showHomeOptions", getShowHomeOptions());
            model.addAttribute("department", departmentDetails);
            return "admin/department/edit";
        }

        Department existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment != null) {
            DepartmentType departmentType = departmentTypeService.getCategoryDepartmentById(departmentDetails.getDepartmentType().getId());
            existingDepartment.setDepartmentType(departmentType);
            existingDepartment.setDepartmentName(departmentDetails.getDepartmentName());
            existingDepartment.setLocation(departmentDetails.getLocation());
            existingDepartment.setShowHome(departmentDetails.getShowHome());
            departmentService.saveDepartment(existingDepartment);
        }
        return "redirect:/admin/department";
    }


    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/admin/department";
    }

    private Map<Boolean, String> getShowHomeOptions() {
        Map<Boolean, String> showHomeOptions = new HashMap<>();
        showHomeOptions.put(false, "No");  // Put "No" first
        showHomeOptions.put(true, "Yes");
        return showHomeOptions;
    }


}
