package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String listBrands (Model model) {
        model.addAttribute("brands", brandService.findAll());
        return "admin/brand/list";
    }

    @GetMapping("/create")
    public String createBrandForm (Model model) {
        model.addAttribute("brand", new Brand());
        return "admin/brand/create";
    }

    @PostMapping("/create")
    public String createBrand (@Valid @ModelAttribute Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/brand/create";
        }
        brandService.save(brand);
        return "redirect:/admin/brand";
    }


    @GetMapping("/edit/{id}")
    public String editBrandForm(@PathVariable Long id, Model model) {
        Brand brand = brandService.getBrandById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thương hiệu có Id:" + id));
        model.addAttribute("brand", brand);
        return "admin/brand/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBrand (@PathVariable Long id, @Valid @ModelAttribute Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/brand/edit";
        }
        brand.setId(id);
        brandService.save(brand);
        return "redirect:/admin/brand";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Long id) {
        Brand brand = brandService.getBrandById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thương hiệu có Id:" + id));
        brandService.deleteById(id);
        return "redirect:/admin/brand";
    }
}
