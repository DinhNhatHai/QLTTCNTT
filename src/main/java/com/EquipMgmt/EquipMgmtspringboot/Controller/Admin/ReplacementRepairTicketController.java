package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/replacement-repair-ticket")
public class ReplacementRepairTicketController {
    @GetMapping
    public String index() {
        return  "admin/replacement_repair_ticket/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin//replacement_repair_ticket/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin//replacement_repair_ticket/edit";
    }
}
