package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/warranty")
public class WarrantyController {
    @GetMapping
    public String index() {
        return  "admin/warranty/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/warranty/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/warranty/edit";
    }
}
