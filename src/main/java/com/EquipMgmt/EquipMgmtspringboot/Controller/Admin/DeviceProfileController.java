package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/device_profile")
public class DeviceProfileController {
    @GetMapping
    public String index() {
        return  "admin/device_profile/list";
    }

    @GetMapping("/create")
    public String create() {
        return  "admin/device_profile/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return  "admin/device_profile/edit";
    }
}
