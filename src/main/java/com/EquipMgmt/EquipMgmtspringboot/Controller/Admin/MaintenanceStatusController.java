package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceStatus;
import com.EquipMgmt.EquipMgmtspringboot.Services.MaintenanceStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance-status")
public class MaintenanceStatusController {

    @Autowired
    private MaintenanceStatusService maintenanceStatusService;

    @GetMapping
    public String listMaintenanceTypes(Model model) {
        model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
        return "admin/maintenance_status/list";
    }

    @GetMapping("/create")
    public String createMaintenanceTypeForm (Model model) {
        model.addAttribute("maintenanceStatus", new MaintenanceStatus());
        return "admin/maintenance_status/create";
    }

    @PostMapping("/create")
    public String createMaintenanceStatus (@Valid @ModelAttribute MaintenanceStatus maintenanceStatus, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/maintenance_status/create";
        }
        maintenanceStatusService.save(maintenanceStatus);
        return "redirect:/admin/maintenance-status";
    }

    @GetMapping("/edit/{id}")
    public String editMaintenanceStatusForm (@PathVariable Long id, Model model) {
        MaintenanceStatus maintenanceStatus = maintenanceStatusService.getMaintenanceStatusById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid MaintenanceStatus Type Id:" + id));
        model.addAttribute("maintenanceStatus", maintenanceStatus);
        return "admin/maintenance_status/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMaintenanceStatus (@PathVariable Long id, @ModelAttribute MaintenanceStatus maintenanceStatus) {
        maintenanceStatus.setId(id);
        maintenanceStatusService.save(maintenanceStatus);
        return "redirect:/admin/maintenance-status";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenanceStatus (@PathVariable Long id) {
        maintenanceStatusService.deleteById(id);
        return "redirect:/admin/maintenance-status";
    }
}
