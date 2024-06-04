package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import com.EquipMgmt.EquipMgmtspringboot.Services.EmployeeService;

import com.EquipMgmt.EquipMgmtspringboot.Services.EmployeeTypeService;
import com.EquipMgmt.EquipMgmtspringboot.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private UserService userService;


    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "admin/employee/list";
    }

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "admin/employee/create";
    }


    @PostMapping("/create")
    public String createEmployeeForm(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeTypes", employeeTypeService.findAll());
            model.addAttribute("users", userService.findAll());
            return "admin/employee/create";
        }
        employeeService.save(employee);
        return "redirect:/admin/employee";
    }


    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại: " + id));
        model.addAttribute("employee", employee);
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "admin/employee/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeTypes", employeeTypeService.findAll());
            model.addAttribute("users", userService.findAll());
            return "admin/employee/edit";
        }
        employee.setId(id);
        employeeService.save(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại:" + id));
        employeeService.deleteById(id);
        return "redirect:/admin/employee";
    }
}
