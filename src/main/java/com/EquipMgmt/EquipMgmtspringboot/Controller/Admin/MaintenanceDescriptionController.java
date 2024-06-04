package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/maintenance-description")
public class MaintenanceDescriptionController {
    @GetMapping
    public String index() {
        return  "admin/maintenance_description/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/maintenance_description/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/maintenance_description/edit";
    }
}