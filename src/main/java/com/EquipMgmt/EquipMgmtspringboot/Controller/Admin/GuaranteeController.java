package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/guarantee")
public class GuaranteeController {
    @GetMapping
    public String index() {
        return  "admin/guarantee/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/guarantee/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/guarantee/edit";
    }
}
