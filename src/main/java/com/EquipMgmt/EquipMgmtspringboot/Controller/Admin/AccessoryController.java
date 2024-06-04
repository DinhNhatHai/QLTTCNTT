package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Accessory;
import com.EquipMgmt.EquipMgmtspringboot.Models.Device;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/accessory")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

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
    public String listAccessories (Model model) {
        model.addAttribute("accessories", accessoryService.findAll());
        return "admin/accessory/list";
    }

    @GetMapping("/create")
    public String createAccessoryForm(Model model) {
        model.addAttribute("accessory", new Accessory());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/accessory/create";
    }

    @PostMapping("/create")
    public String createAccessoryForm(@Valid @ModelAttribute Accessory accessory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/accessory/create";
        }
        accessoryService.save(accessory);
        return "redirect:/admin/accessory";
    }

    @GetMapping("/edit/{id}")
    public String editAccessoryForm(@PathVariable Long id, Model model) {
        Accessory accessory = accessoryService.getAccessoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại linh phụ kiện có Id: " + id));
        model.addAttribute("accessory", accessory);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/accessory/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAccessory (@PathVariable Long id, @Valid @ModelAttribute Accessory accessory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/accessory/edit";
        }
        accessory.setId(id);
        accessoryService.save(accessory);
        return "redirect:/admin/accessory";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccessory (@PathVariable Long id) {
        Accessory accessory = accessoryService.getAccessoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại linh phụ kiện có Id:" + id));
        accessoryService.deleteById(id);
        return "redirect:/admin/accessory";
    }
}
