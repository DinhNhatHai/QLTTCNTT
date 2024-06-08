package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Guarantee;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/guarantee")
public class GuaranteeController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private GuaranteeService guaranteeService;

    @GetMapping
    public String listGuarantees (Model model) {
        model.addAttribute("guarantees", guaranteeService.findAll());
        return "admin/guarantee/list";
    }

    @GetMapping("/create")
    public String createGuaranteeForm(Model model) {
        model.addAttribute("guarantee", new Guarantee());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/guarantee/create";
    }

    @PostMapping("/create")
    public String createGuaranteeForm(@Valid @ModelAttribute Guarantee guarantee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/guarantee/create";
        }
        guaranteeService.save(guarantee);
        return "redirect:/admin/guarantee";
    }

    @GetMapping("/edit/{id}")
    public String editGuaranteeForm(@PathVariable Long id, Model model) {
        Guarantee guarantee = guaranteeService.getGuaranteeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại bảo hành bị có Id: " + id));
        model.addAttribute("guarantee", guarantee);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/guarantee/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateGuarantee (@PathVariable Long id, @Valid @ModelAttribute Guarantee guarantee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/guarantee/edit";
        }

        guarantee.setId(id);
        guaranteeService.save(guarantee);
        return "redirect:/admin/guarantee";
    }

    @GetMapping("/delete/{id}")
    public String deleteGuarantee (@PathVariable Long id) {
        Guarantee guarantee = guaranteeService.getGuaranteeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại bảo hành có Id:" + id));
        guaranteeService.deleteById(id);
        return "redirect:/admin/guarantee";
    }
}
