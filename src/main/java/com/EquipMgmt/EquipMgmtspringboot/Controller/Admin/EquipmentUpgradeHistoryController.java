package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/equipment-upgrade-history")
public class EquipmentUpgradeHistoryController {
    @GetMapping
    public String index() {
        return  "admin/equipment_upgrade_history/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/equipment_upgrade_history/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/equipment_upgrade_history/edit";
    }
}
