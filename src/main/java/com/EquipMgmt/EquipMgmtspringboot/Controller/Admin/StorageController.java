package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/storage")
public class StorageController {
    @GetMapping
    public String index() {
        return  "admin/storage/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/storage/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/storage/edit";
    }
}