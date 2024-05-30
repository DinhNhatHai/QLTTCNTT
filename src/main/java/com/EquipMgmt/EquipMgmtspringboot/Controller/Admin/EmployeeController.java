package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
    @GetMapping
    public String index() {
        return  "admin/employee/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/employee/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/employee/edit";
    }
}
