package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "admin/login";
    }

    @GetMapping("/redirect")
    public String redirectToLogin() {
        return "redirect:/admin/login";
    }
}
