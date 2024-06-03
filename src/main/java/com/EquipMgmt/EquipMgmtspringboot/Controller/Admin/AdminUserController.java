package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.User;
import com.EquipMgmt.EquipMgmtspringboot.Services.EmployeeTypeService;
import com.EquipMgmt.EquipMgmtspringboot.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeTypeService employeeTypeService;


    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("users", new User());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return "admin/users/create";
    }

    @PostMapping("/create")
    public String createUsers(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/users/create";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getId(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tài tại khoản:" + id));
        model.addAttribute("users", user);
        return "admin/users/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployeeType(@PathVariable Long id, @Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/users/edit";
        }
        user.setId(id);
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        User user = userService.getId(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tài tại khoản:" + id));
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}