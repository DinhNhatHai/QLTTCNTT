package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin/equipment-system")
public class EquipmentSystemController {
    @GetMapping
    public String index() {
        return  "admin/equipment_system/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/equipment_system/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/equipment_system/edit";
    }
}
