package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/profile-equipments")
public class ProfileEquipmentController {
    @GetMapping
    public String index() {
        return  "admin/profile_equipments/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/profile_equipments/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/profile_equipments/edit";
    }
}
