package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/sub-category")
public class SubCategoryController {
    @GetMapping
    public String index() {
        return  "admin/sub_category/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/sub_category/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/sub_category/edit";
    }
}
