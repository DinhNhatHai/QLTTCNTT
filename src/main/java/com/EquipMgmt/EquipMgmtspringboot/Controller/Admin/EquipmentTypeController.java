package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentType;
import com.EquipMgmt.EquipMgmtspringboot.Services.CategoryService;
import com.EquipMgmt.EquipMgmtspringboot.Services.EquipmentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/equipment-type")
public class EquipmentTypeController {
    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listEquipmentTypes (Model model) {
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        return "admin/equipment_type/list";
    }


    @GetMapping("/create")
    public String createEquipmentTypeForm(Model model) {
        model.addAttribute("equipmentType", new EquipmentType ());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment_type/create";
    }

    @PostMapping("/create")
    public String createEquipmentType (@Valid @ModelAttribute EquipmentType  equipmentType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment_type/create";
        }
        equipmentTypeService.save(equipmentType);
        return "redirect:/admin/equipment-type";
    }

    @GetMapping("/edit/{id}")
    public String editEquipmentTypeForm (@PathVariable Long id, Model model) {
        EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại trang thiết bị Id:" + id));
        model.addAttribute("equipmentType", equipmentType);
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment_type/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEquipmentType (@PathVariable Long id, @Valid @ModelAttribute EquipmentType equipmentType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment_type/edit";
        }
        equipmentType.setId(id);
        equipmentTypeService.save(equipmentType);
        return "redirect:/admin/equipment-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipmentType (@PathVariable Long id) {
        EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại trang thiết bị Id:" + id));
        equipmentTypeService.deleteById(id);
        return "redirect:/admin/equipment-type";
    }
}
