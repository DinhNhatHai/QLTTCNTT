package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/category-department")
public class CategoryDepartmentController {
    @GetMapping
    public String index() {
        return  "admin/category_department/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/category_department/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/category_department/edit";
    }
}
