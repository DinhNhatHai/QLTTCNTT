package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubRole;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/sub-roles")
public class SubRoleController {

    @Autowired
    private SubRoleService subRoleService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listSubRoles(Model model) {
        model.addAttribute("subRoles", subRoleService.findAll());
        return "admin/sub_roles/list";
    }

    @GetMapping("/create")
    public String createSubRoleForm(Model model) {
        model.addAttribute("subRoles", new SubRole());
        model.addAttribute("roles", roleService.findAll());
        return "admin/sub_roles/create";
    }


    @PostMapping("/create")
    public String createEmployeeForm(@Valid @ModelAttribute SubRole subRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.findAll());
            return "admin/sub_roles/create";
        }
        subRoleService.save(subRole);
        return "redirect:/admin/sub-roles";
    }


    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        SubRole subRole = subRoleService.getSubRoleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại: " + id));
        model.addAttribute("subRoles", subRole);
        model.addAttribute("roles", roleService.findAll());
        return "admin/sub_roles/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute SubRole subRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.findAll());
            return "admin/sub_roles/edit";
        }
        subRole.setId(id);
        subRoleService.save(subRole);
        return "redirect:/admin/sub-roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        SubRole subRole = subRoleService.getSubRoleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại:" + id));
        subRoleService.deleteById(id);
        return "redirect:/admin/sub-roles";
    }
}
