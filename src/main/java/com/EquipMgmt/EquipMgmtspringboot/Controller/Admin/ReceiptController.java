package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/receipt")
public class ReceiptController {
    @GetMapping
    public String index() {
        return  "admin/receipt/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/receipt/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/receipt/edit";
    }
}
