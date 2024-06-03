package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceType;
import com.EquipMgmt.EquipMgmtspringboot.Models.Vendor;
import com.EquipMgmt.EquipMgmtspringboot.Services.MaintenanceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/maintenance-type")
public class MaintenanceTypeController {

    @Autowired
    private MaintenanceTypeService maintenanceTypeService;

    @GetMapping
    public String listMaintenanceTypes(Model model) {
        model.addAttribute("maintenanceTypes", maintenanceTypeService.findAll());
        return "admin/maintenance_type/list";
    }


    @GetMapping("/create")
    public String createVendorForm(Model model) {
        model.addAttribute("maintenanceType", new MaintenanceType());
        return "admin/maintenance_type/create";
    }

    @PostMapping("/create")
    public String createVendor(@Valid @ModelAttribute MaintenanceType maintenanceType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/maintenance_type/create";
        }
        maintenanceTypeService.save(maintenanceType);
        return "redirect:/admin/maintenance-type";
    }

//    @GetMapping("/create")
//    public String createMaintenanceTypeForm(Model model) {
//        model.addAttribute("maintenanceType", new MaintenanceType());
//        return "admin/maintenance_type/create";
//    }
//
//    @PostMapping("/create")
//    public String createMaintenanceType(@ModelAttribute MaintenanceType maintenanceType) {
//        maintenanceTypeService.save(maintenanceType);
//        return "redirect:/admin/maintenance_type";
//    }

    @GetMapping("/edit/{id}")
    public String editMaintenanceTypeForm(@PathVariable Long id, Model model) {
        MaintenanceType maintenanceType = maintenanceTypeService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Maintenance Type Id:" + id));
        model.addAttribute("maintenanceType", maintenanceType);
        return "admin/maintenance_type/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMaintenanceType(@PathVariable Long id, @ModelAttribute MaintenanceType maintenanceType) {
        maintenanceType.setId(id);
        maintenanceTypeService.save(maintenanceType);
        return "redirect:/admin/maintenance-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenanceType(@PathVariable Long id) {
        maintenanceTypeService.deleteById(id);
        return "redirect:/admin/maintenance-type";
    }
}
