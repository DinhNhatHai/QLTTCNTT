package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Department;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentTypeService departmentTypeService;

    @GetMapping
    public String listDepartments (Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "admin/department/list";
    }

    @GetMapping("/create")
    public String createDepartmentForm (Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("departmentTypes", departmentTypeService.findAll());
        return "admin/department/create";
    }


    @PostMapping("/create")
    public String createDepartmentForm (@Valid @ModelAttribute Department department, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departmentTypes", departmentTypeService.findAll());
            return "admin/department/create";
        }
        departmentService.save(department);
        return "redirect:/admin/department";
    }


    @GetMapping("/edit/{id}")
    public String editDepartmentForm (@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại: " + id));
        model.addAttribute("department", department);
        model.addAttribute("departmentTypes", departmentTypeService.findAll());
        return "admin/department/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDepartment (@PathVariable Long id, @Valid @ModelAttribute Department department, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departmentTypes", departmentTypeService.findAll());
            return "admin/department/edit";
        }
        department.setId(id);
        departmentService.save(department);
        return "redirect:/admin/department";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment (@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại:" + id));
        departmentService.deleteById(id);
        return "redirect:/admin/department";
    }
}
