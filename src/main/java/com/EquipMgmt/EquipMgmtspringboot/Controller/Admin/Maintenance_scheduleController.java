package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/maintenance-schedule")

public class Maintenance_scheduleController {
    @GetMapping
    public String index() {
        return  "admin/maintenance_schedule/list";
    }
    @GetMapping("/create")
    public String create() {
        return  "admin/maintenance_schedule/create";
    }
    @GetMapping("/edit")
    public String edit() {
        return  "admin/maintenance_schedule/edit";
    }
}
