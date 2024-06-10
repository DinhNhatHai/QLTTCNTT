package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/maintenance")
public class MaintenanceController {
    @GetMapping
    public String index() {
        return  "admin/maintenance/list";
    }
    @GetMapping("/create")
    public String create() {
        return  "admin/maintenance/create";
    }
    @GetMapping("/edit")
    public String edit() {
        return  "admin/maintenance/edit";
    }
}