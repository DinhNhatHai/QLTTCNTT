package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.CurrencyUtils;
import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import com.EquipMgmt.EquipMgmtspringboot.Models.Maintenance;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance")
public class MaintenanceController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MaintenanceDescriptionService maintenanceDescriptionService;

    @Autowired
    private MaintenanceScheduleService maintenanceScheduleService;

    @Autowired
    private MaintenanceTypeService maintenanceTypeService;

    @Autowired
    private MaintenanceStatusService maintenanceStatusService;

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public String listMaintenances (Model model) {
        model.addAttribute("maintenances", maintenanceService.findAll());
//        model.addAttribute("utils", new CurrencyUtils());
        return "admin/maintenance/list";
    }

    @GetMapping("/create")
    public String createMaintenanceForm(Model model) {
        model.addAttribute("maintenance", new Maintenance());
        model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
        model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
        model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
        model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/maintenance/create";
    }


    @PostMapping("/create")
    public String createMaintenanceForm(@Valid @ModelAttribute Maintenance maintenance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
            model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
            model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
            model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/maintenance/create";
        }
        maintenanceService.save(maintenance);
        return "redirect:/admin/maintenance";
    }


    @GetMapping("/edit/{id}")
    public String editMaintenanceForm(@PathVariable Long id, Model model) {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại bảo trì có Id:" + id));

        model.addAttribute("maintenance", maintenance);
        model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
        model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
        model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
        model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/maintenance/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMaintenance(@PathVariable Long id, @Valid @ModelAttribute Maintenance maintenance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("maintenance", maintenance);
            model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
            model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
            model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
            model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/maintenance/edit"; // Đảm bảo trả về đúng view
        }
        maintenance.setId(id);
        maintenanceService.save(maintenance);
        return "redirect:/admin/maintenance";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenance (@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại bảo trì có Id:" + id));
        maintenanceService.deleteById(id);
        return "redirect:/admin/maintenance";
    }
}