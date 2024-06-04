package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EmployeeType;
import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipmentType;
import com.EquipMgmt.EquipMgmtspringboot.Services.StatusEquipmentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/status-equipment-type")
public class StatusEquipmentTypeController {

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @GetMapping
    public String listStatusEquipmentTypes (Model model) {
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        return "admin/status_equipment_type/list";
    }

    @GetMapping("/create")
    public String createStatusEquipmentTypeForm(Model model) {
        model.addAttribute("statusEquipmentType", new StatusEquipmentType());
        return "admin/status_equipment_type/create";
    }

    @PostMapping("/create")
    public String createStatusEquipmentTypes (@Valid @ModelAttribute StatusEquipmentType statusEquipmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/status_equipment_type/create";
        }
        statusEquipmentTypeService.save(statusEquipmentType);
        return "redirect:/admin/status-equipment-type";
    }


    @GetMapping("/edit/{id}")
    public String editStatusEquipmentTypeForm(@PathVariable Long id, Model model) {
        StatusEquipmentType statusEquipmentType = statusEquipmentTypeService.getStatusEquipmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại tình trạng trang thiết bị có id:" + id));
        model.addAttribute("statusEquipmentType", statusEquipmentType);
        return "admin/status_equipment_type/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStatusEquipmentTypes (@PathVariable Long id, @Valid @ModelAttribute StatusEquipmentType statusEquipmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/status_equipment_type/edit";
        }
        statusEquipmentType.setId(id);
        statusEquipmentTypeService.save(statusEquipmentType);
        return "redirect:/admin/status-equipment-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteStatusEquipmentTypes (@PathVariable Long id) {
        StatusEquipmentType statusEquipmentType = statusEquipmentTypeService.getStatusEquipmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại tình trạng trang thiết bị có id:" + id));
        statusEquipmentTypeService.deleteById(id);
        return "redirect:/admin/status-equipment-type";
    }
}
