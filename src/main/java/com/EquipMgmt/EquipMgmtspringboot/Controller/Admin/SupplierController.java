package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/supplier")
public class SupplierController {
    @GetMapping
    public String index() {
        return  "admin/supplier/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/supplier/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/supplier/edit";
    }
}
