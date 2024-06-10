package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/maintenance-plan")
public class MaintenancePlanController {
    @GetMapping
    public String index() {
        return  "admin/maintenance_plan/list";
    }
    @GetMapping("/create")
    public String create() {
        return  "admin/maintenance_plan/create";
    }
    @GetMapping("/edit")
    public String edit() {
        return  "admin/maintenance_plan/edit";
    }
}
