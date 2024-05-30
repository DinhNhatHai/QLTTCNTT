package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/delivery-bill")
public class DeliveryBillController {
    @GetMapping
    public String index() {
        return  "admin/delivery_bill/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/delivery_bill/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/delivery_bill/edit";
    }
}
