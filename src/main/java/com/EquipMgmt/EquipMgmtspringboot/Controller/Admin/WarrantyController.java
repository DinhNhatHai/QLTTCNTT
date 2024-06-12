package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warranty;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/warranty")
public class WarrantyController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GuaranteeService guaranteeService;

    @Autowired
    private WarrantyService warrantyService;

    @GetMapping
    public String listWarranties (Model model) {
        model.addAttribute("warranties", warrantyService.findAll());
        return "admin/warranty/list";
    }

    @GetMapping("/create")
    public String createWarrantyForm(Model model) {
        model.addAttribute("warranty", new Warranty());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("guarantees", guaranteeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/warranty/create";
    }

    @PostMapping("/create")
    public String createWarrantyForm(@Valid @ModelAttribute Warranty warranty, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("guarantees", guaranteeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/warranty/create";
        }
        warrantyService.save(warranty);
        return "redirect:/admin/warranty";
    }

    @GetMapping("/edit/{id}")
    public String editWarrantyForm(@PathVariable Long id, Model model) {
        Warranty warranty = warrantyService.getWarrantyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu bảo hành bị có Id: " + id));
        model.addAttribute("warranty", warranty);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("guarantees", guaranteeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/warranty/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateWarranty (@PathVariable Long id, @Valid @ModelAttribute Warranty warranty, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("guarantees", guaranteeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/warranty/edit";
        }

        warranty.setId(id);
        warrantyService.save(warranty);
        return "redirect:/admin/warranty";
    }

    @GetMapping("/delete/{id}")
    public String deleteWarranty (@PathVariable Long id) {
        Warranty warranty = warrantyService.getWarrantyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu bảo hành có Id:" + id));
        warrantyService.deleteById(id);
        return "redirect:/admin/warranty";
    }
}
