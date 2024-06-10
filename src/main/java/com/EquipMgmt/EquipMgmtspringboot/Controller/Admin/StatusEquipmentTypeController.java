package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/status-equipment-type")
public class StatusEquipmentTypeController {
    @GetMapping
    public String index() {
        return  "admin/status_equipment_type/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/status_equipment_type/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/status_equipment_type/edit";
    }
}



