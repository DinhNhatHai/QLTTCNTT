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
    public String index(Model model) {
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "admin/brand/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("brand", new Brand());
        return "admin/brand/create";
    }

    @PostMapping("/create")
    public String createBrand(@ModelAttribute Brand brand) {
        brandService.createBrand(brand);
        return "redirect:/admin/brand"; // Chuyển hướng người dùng đến trang danh sách sau khi tạo mới thành công
    }

    @GetMapping("/edit")
    public String edit() {
        return "admin/brand/edit";
    }
//
//    @PostMapping("/edit}")
//    public String updateBrand(@PathVariable Long id, @ModelAttribute Brand brand) {
//        brandService.updateBrand(id, brand);
//        return "redirect:/admin/brand"; // Chuyển hướng người dùng đến trang danh sách sau khi cập nhật thành công
//    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return "redirect:/admin/brand"; // Chuyển hướng người dùng đến trang danh sách sau khi xóa thành công
    }
}
