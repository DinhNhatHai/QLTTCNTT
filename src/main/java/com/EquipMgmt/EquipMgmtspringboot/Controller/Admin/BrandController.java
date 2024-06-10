package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllBrands(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Brand> brands;
        if (keyword != null && !keyword.isEmpty()) {
            brands = brandService.searchBrandsByName(keyword);
        } else {
            brands = brandService.getAllBrands();
        }
        model.addAttribute("brands", brands);
        return "admin/brand/list";
    }

    @GetMapping("/create")
    public String createBrandForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "admin/brand/create";
    }

    @PostMapping("/create")
    public String createBrand(@ModelAttribute("brand") Brand brand) {
        brandService.saveBrand(brand);
        return "redirect:/admin/brand";
    }

    @GetMapping("/edit/{id}")
    public String editBrandForm(@PathVariable Long id, Model model) {
        Brand brand = brandService.getBrandById(id);
        if (brand != null) {
            model.addAttribute("brand", brand);
            return "admin/brand/edit";
        }
        return "redirect:/admin/brand";
    }

    @PostMapping("/edit/{id}")
    public String editBrand(@PathVariable Long id, @ModelAttribute("brand") Brand brand) {
        brand.setId(id);
        brandService.saveBrand(brand);
        return "redirect:/admin/brand";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return "redirect:/admin/brand";
    }
}
