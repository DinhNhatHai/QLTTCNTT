package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/qr-code")
public class QRcodeController {
    @GetMapping
    public String index() {
        return  "admin/qr_code/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/qr_code/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/qr_code/edit";
    }
}
