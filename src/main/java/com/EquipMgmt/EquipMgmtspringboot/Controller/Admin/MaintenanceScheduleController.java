package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceSchedule;
import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceType;
import com.EquipMgmt.EquipMgmtspringboot.Services.MaintenanceScheduleService;
import com.EquipMgmt.EquipMgmtspringboot.Services.MaintenanceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance-schedule")
public class MaintenanceScheduleController {

    @Autowired
    private MaintenanceScheduleService maintenanceScheduleService;

    @GetMapping
    public String listMaintenanceSchedules (Model model) {
        model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
        return "admin/maintenance_schedule/list";
    }

    @GetMapping("/create")
    public String createMaintenanceScheduleForm (Model model) {
        model.addAttribute("maintenanceSchedule", new MaintenanceSchedule());
        return "admin/maintenance_schedule/create";
    }

    @PostMapping("/create")
    public String createMaintenanceSchedule (@Valid @ModelAttribute MaintenanceSchedule maintenanceSchedule, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/maintenance_schedule/create";
        }
        maintenanceScheduleService.save(maintenanceSchedule);
        return "redirect:/admin/maintenance-schedule";
    }

    @GetMapping("/edit/{id}")
    public String editMMaintenanceScheduleForm (@PathVariable Long id, Model model) {
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleService.getMaintenanceScheduleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid MaintenanceSchedule Type Id:" + id));
        model.addAttribute("maintenanceSchedule", maintenanceSchedule);
        return "admin/maintenance_schedule/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMaintenanceSchedule (@PathVariable Long id, @ModelAttribute MaintenanceSchedule maintenanceSchedule) {
        maintenanceSchedule.setId(id);
        maintenanceScheduleService.save(maintenanceSchedule);
        return "redirect:/admin/maintenance-schedule";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenanceSchedule (@PathVariable Long id) {
        maintenanceScheduleService.deleteById(id);
        return "redirect:/admin/maintenance-schedule";
    }
}