package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StatusEquipmentService statusEquipmentService;

    @Autowired
    private EquipmentTypeService equipmentTypeService;


    @GetMapping
    public String listDevices(Model model) {
        model.addAttribute("equipments", equipmentService.findAll());
        return "admin/equipment/list";
    }


    @GetMapping("/create")
    public String createEquipmentForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment/create";
    }

    @PostMapping("/create")
    public String createEquipmentForm(@Valid @ModelAttribute Equipment equipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment/create";
        }
        equipmentService.save(equipment);
        return "redirect:/admin/equipment";
    }


    @GetMapping("/edit/{id}")
    public String editEquipmentForm(@PathVariable Long id, Model model) {
        Equipment equipment = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id: " + id));
        model.addAttribute("equipment", equipment);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEquipment (@PathVariable Long id, @Valid @ModelAttribute Equipment equipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment/edit";
        }

        equipment.setId(id);
        equipmentService.save(equipment);
        return "redirect:/admin/equipment";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipment (@PathVariable Long id) {
        Equipment equipment = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id:" + id));
        equipmentService.deleteById(id);
        return "redirect:/admin/equipment";
    }
}
