package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.UserSubRoles;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user-sub-roles")
public class UserSubRoleController {

    @Autowired
    private UserSubRoleService userSubRoleService;

    @Autowired
    private SubRoleService subRoleService;

    @Autowired
    private UserService userService;


    @GetMapping
    public String listUserSubRoles(Model model) {
        model.addAttribute("userSubRoles", userSubRoleService.findAll());
        return "admin/user_sub_roles/list";
    }

    @GetMapping("/create")
    public String createUserSubRoleForm(Model model) {
        model.addAttribute("userSubRole", new UserSubRoles());
        model.addAttribute("subRoles", subRoleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "admin/user_sub_roles/create";
    }

    @PostMapping("/create")
    public String createUserSubRoleForm(@Valid @ModelAttribute UserSubRoles userSubRoles, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subRoles", subRoleService.findAll());
            model.addAttribute("users", userService.findAll());
            return "admin/user_sub_roles/create";
        }
        userSubRoleService.save(userSubRoles);
        return "redirect:/admin/user-sub-roles";
    }

    @GetMapping("/edit/{id}")
    public String editUserSubRoleForm(@PathVariable Long id, Model model) {
        UserSubRoles userSubRoles = userSubRoleService.getUserSubRoleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại: " + id));
        model.addAttribute("userSubRole", userSubRoles);
        model.addAttribute("subRoles", subRoleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "admin/user_sub_roles/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateUserSubRoles(@PathVariable Long id, @Valid @ModelAttribute UserSubRoles userSubRoles, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subRoles", subRoleService.findAll());
            model.addAttribute("users", userService.findAll());
            return "admin/user_sub_roles/edit";
        }
        userSubRoles.setId(id);
        userSubRoleService.save(userSubRoles);
        return "redirect:/admin/user-sub-roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserSubRoles(@PathVariable Long id) {
        UserSubRoles userSubRoles = userSubRoleService.getUserSubRoleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại:" + id));
        userSubRoleService.deleteById(id);
        return "redirect:/admin/user-sub-roles";
    }
}
