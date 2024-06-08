package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenancePlan;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance-plan")
public class MaintenancePlanController {

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
    private MaintenancePlanService maintenancePlanService;

    @GetMapping
    public String listMaintenancePlans (Model model) {
        model.addAttribute("maintenancePlans", maintenancePlanService.findAll());
        return "admin/maintenance_plan/list";
    }

    @GetMapping("/create")
    public String createMaintenancePlanForm(Model model) {
        model.addAttribute("maintenancePlan", new MaintenancePlan());
        model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
        model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
        model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
        model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/maintenance_plan/create";
    }

    @PostMapping("/create")
    public String createMaintenancePlanForm(@Valid @ModelAttribute MaintenancePlan maintenancePlan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
            model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
            model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
            model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/maintenance_plan/create";
        }
        maintenancePlanService.save(maintenancePlan);
        return "redirect:/admin/maintenance-plan";
    }


    @GetMapping("/edit/{id}")
    public String editMaintenancePlanForm (@PathVariable Long id, Model model) {
        MaintenancePlan maintenancePlan = maintenancePlanService.getMaintenancePlanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại kế hoạch bảo trì có Id:" + id));

        model.addAttribute("maintenancePlan", maintenancePlan);
        model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
        model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
        model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
        model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/maintenance_plan/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMMaintenancePlan (@PathVariable Long id, @Valid @ModelAttribute MaintenancePlan MaintenancePlan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("maintenancePlan", MaintenancePlan);
            model.addAttribute("maintenanceDescriptions", maintenanceDescriptionService.findAll());
            model.addAttribute("maintenanceSchedules", maintenanceScheduleService.findAll());
            model.addAttribute("maintenanceStatuses", maintenanceStatusService.findAll());
            model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/maintenance_plan/edit";
        }
        MaintenancePlan.setId(id);
        maintenancePlanService.save(MaintenancePlan);
        return "redirect:/admin/maintenance-plan";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenancePlan (@PathVariable Long id) {
        MaintenancePlan MaintenancePlan = maintenancePlanService.getMaintenancePlanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn kế hoạch tại bảo trì có Id:" + id));
        maintenancePlanService.deleteById(id);
        return "redirect:/admin/maintenance-plan";
    }
}