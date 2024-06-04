package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipment;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/status-equipment")
public class StatusEquipmentController {

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @Autowired
    private StatusEquipmentService statusEquipmentService;

    @GetMapping
    public String listStatusEquipments (Model model) {
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        return "admin/status_equipment/list";
    }

    @GetMapping("/create")
    public String createStatusEquipmentForm(Model model) {
        model.addAttribute("statusEquipment", new StatusEquipment());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        return "admin/status_equipment/create";
    }


    @PostMapping("/create")
    public String createStatusEquipmentForm(@Valid @ModelAttribute StatusEquipment statusEquipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            return "admin/status_equipment/create";
        }
        statusEquipmentService.save(statusEquipment);
        return "redirect:/admin/status-equipment";
    }


    @GetMapping("/edit/{id}")
    public String editStatusEquipmentForm (@PathVariable Long id, Model model) {
        StatusEquipment statusEquipment = statusEquipmentService.getStatusEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại tình trạng trang thiết bị có id: " + id));
        model.addAttribute("statusEquipment", statusEquipment);
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        return "admin/status_equipment/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStatusEquipment (@PathVariable Long id, @Valid @ModelAttribute StatusEquipment statusEquipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            return "admin/status_equipment/edit";
        }
        statusEquipment.setId(id);
        statusEquipmentService.save(statusEquipment);
        return "redirect:/admin/status-equipment";
    }

    @GetMapping("/delete/{id}")
    public String deleteStatusEquipment (@PathVariable Long id) {
        StatusEquipment statusEquipment = statusEquipmentService.getStatusEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại tình trạng trang thiết bị có id:" + id));
        statusEquipmentService.deleteById(id);
        return "redirect:/admin/status-equipment";
    }
}
