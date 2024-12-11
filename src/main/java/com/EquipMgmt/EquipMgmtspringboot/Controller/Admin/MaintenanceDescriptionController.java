package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceDescription;
import com.EquipMgmt.EquipMgmtspringboot.Services.MaintenanceDescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance-description")
public class MaintenanceDescriptionController {

    @Autowired
    private MaintenanceDescriptionService maintenanceDescriptionService;

    @GetMapping
    public String listMaintenanceDescriptions (Model model) {
        model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
        return "admin/maintenance_description/list";
    }

    @GetMapping("/create")
    public String createMaintenanceDescriptionForm(Model model) {
        model.addAttribute("maintenanceDescription", new MaintenanceDescription());
        return "admin/maintenance_description/create";
    }

    @PostMapping("/create")
    public String createMaintenanceDescription (@Valid @ModelAttribute MaintenanceDescription maintenanceDescription, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/maintenance_description/create";
        }
        maintenanceDescriptionService.save(maintenanceDescription);
        return "redirect:/admin/maintenance-description";
    }


    @GetMapping("/edit/{id}")
    public String editMaintenanceDescriptionForm (@PathVariable Long id, Model model) {
        MaintenanceDescription maintenanceDescription = maintenanceDescriptionService.getMaintenanceDescriptionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid MaintenanceDescription Id:" + id));
        model.addAttribute("maintenanceDescription", maintenanceDescription);
        return "admin/maintenance_description/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMaintenanceDescription (@PathVariable Long id, @Valid @ModelAttribute MaintenanceDescription maintenanceDescription, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/maintenance_description/edit";
        }
        maintenanceDescription.setId(id);
        maintenanceDescriptionService.save(maintenanceDescription);
        return "redirect:/admin/maintenance-description";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenanceDescription (@PathVariable Long id) {
        MaintenanceDescription maintenanceDescription = maintenanceDescriptionService.getMaintenanceDescriptionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid MaintenanceDescription Id:" + id));
        maintenanceDescriptionService.deleteById(id);
        return "redirect:/admin/maintenance-description";
    }
}