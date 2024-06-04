package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentSystem;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/equipment-system")
public class EquipmentSystemController {

    @Autowired
    private EquipmentSystemService equipmentSystemService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StatusEquipmentService statusEquipmentService;

    @Autowired
    private SubCategoryService subCategoryService;


    @GetMapping
    public String listDevices(Model model) {
        model.addAttribute("equipmentSystems", equipmentSystemService.findAll());
        return "admin/equipment_system/list";
    }


    @GetMapping("/create")
    public String createEquipmentSystemForm(Model model) {
        model.addAttribute("equipmentSystem", new EquipmentSystem());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/equipment_system/create";
    }

    @PostMapping("/create")
    public String createEquipmentSystemForm(@Valid @ModelAttribute EquipmentSystem equipmentSystem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/equipment_system/create";
        }
        equipmentSystemService.save(equipmentSystem);
        return "redirect:/admin/equipment-system";
    }


    @GetMapping("/edit/{id}")
    public String editEquipmentSystemForm(@PathVariable Long id, Model model) {
        EquipmentSystem equipmentSystem = equipmentSystemService.getEquipmentSystemById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id: " + id));
        model.addAttribute("equipmentSystem", equipmentSystem);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/equipment_system/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEquipmentSystem (@PathVariable Long id, @Valid @ModelAttribute EquipmentSystem equipmentSystem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/equipment_system/edit";
        }
        equipmentSystem.setId(id);
        equipmentSystemService.save(equipmentSystem);
        return "redirect:/admin/equipment-system";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipmentSystem (@PathVariable Long id) {
        EquipmentSystem equipmentSystem = equipmentSystemService.getEquipmentSystemById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id:" + id));
        equipmentSystemService.deleteById(id);
        return "redirect:/admin/equipment-system";
    }
}
