package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Vendor;
import com.EquipMgmt.EquipMgmtspringboot.Services.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public String listVendors(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Vendor> vendors;
        if (keyword != null && !keyword.isEmpty()) {
            vendors = vendorService.searchVendorsByName(keyword);
        } else {
            vendors = vendorService.findAll();
        }
        model.addAttribute("vendors", vendors);
        return "admin/vendor/list";
    }

    @GetMapping("/create")
    public String createVendorForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "admin/vendor/create";
    }

    @PostMapping("/create")
    public String createVendor(@Valid @ModelAttribute Vendor vendor, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/vendor/create";
        }
        vendorService.save(vendor);
        return "redirect:/admin/vendor";
    }

    @GetMapping("/edit/{id}")
    public String editVendorForm(@PathVariable Long id, Model model) {
        Vendor vendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại nhà cung cấp mà bạn muốn chỉnh sửa:" + id));
        model.addAttribute("vendor", vendor);
        return "admin/vendor/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateVendor(@PathVariable Long id, @Valid @ModelAttribute Vendor vendor, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/vendor/edit";
        }
        vendor.setId(id);
        vendorService.save(vendor);
        return "redirect:/admin/vendor";
    }

    @GetMapping("/delete/{id}")
    public String deleteVendor(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại nhà cung cấp mà bạn muốn xóa" + id));
        vendorService.deleteById(id);
        return "redirect:/admin/vendor";
    }
}
