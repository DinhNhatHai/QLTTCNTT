package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Device;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

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
        model.addAttribute("devices", deviceService.findAll());
        return "admin/device/list";
    }


    @GetMapping("/create")
    public String createDeviceForm(Model model) {
        model.addAttribute("device", new Device());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/device/create";
    }

    @PostMapping("/create")
    public String createDeviceForm(@Valid @ModelAttribute Device device, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/device/create";
        }
        deviceService.save(device);
        return "redirect:/admin/device";
    }


    @GetMapping("/edit/{id}")
    public String editDeviceForm(@PathVariable Long id, Model model) {
        Device device = deviceService.getDeviceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thiết bị có Id: " + id));
        model.addAttribute("device", device);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/device/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDevice(@PathVariable Long id, @Valid @ModelAttribute Device device, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("subCategories", subCategoryService.findAll());
            return "admin/device/edit";
        }
        device.setId(id);
        deviceService.save(device);
        return "redirect:/admin/device";
    }

    @GetMapping("/delete/{id}")
    public String deleteDevice (@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thiết bị có Id:" + id));
        deviceService.deleteById(id);
        return "redirect:/admin/device";
    }
}