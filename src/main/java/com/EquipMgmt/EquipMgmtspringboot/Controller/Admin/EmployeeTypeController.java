package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import com.EquipMgmt.EquipMgmtspringboot.Services.EmployeeTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/employee-type")
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping
    public String listEmployeeTypes(Model model) {
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return "admin/employee_type/list";
    }

    @GetMapping("/create")
    public String createEmployeeTypeForm(Model model) {
        model.addAttribute("employeeType", new EmployeeType());
        return "admin/employee_type/create";
    }

    @PostMapping("/create")
    public String createEmployeeType(@Valid @ModelAttribute EmployeeType employeeType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/employee_type/create";
        }
        employeeTypeService.save(employeeType);
        return "redirect:/admin/employee-type";
    }


    @GetMapping("/edit/{id}")
    public String editEmployeeTypeForm(@PathVariable Long id, Model model) {
        EmployeeType employeeType = employeeTypeService.getEmployeeTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid EmployeeType Id:" + id));
        model.addAttribute("employeeType", employeeType);
        return "admin/employee_type/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployeeType(@PathVariable Long id, @Valid @ModelAttribute EmployeeType employeeType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/employee_type/edit";
        }
        employeeType.setId(id);
        employeeTypeService.save(employeeType);
        return "redirect:/admin/employee-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeType(@PathVariable Long id) {
        EmployeeType employeeType = employeeTypeService.getEmployeeTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid EmployeeType Id:" + id));
        employeeTypeService.deleteById(id);
        return "redirect:/admin/employee-type";
    }
}
