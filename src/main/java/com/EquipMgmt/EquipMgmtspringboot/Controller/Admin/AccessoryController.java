package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin/accessory")
public class AccessoryController {
    @GetMapping
    public String index() {
        return  "admin/accessory/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/accessory/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/accessory/edit";
    }
}
