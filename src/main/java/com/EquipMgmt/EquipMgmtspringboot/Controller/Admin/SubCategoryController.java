package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/sub-category")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listSubCategory (Model model) {
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "admin/sub_category/list";
    }

    @GetMapping("/create")
    public String createSubCategoryForm(Model model) {
        model.addAttribute("subCategory", new SubCategory());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/sub_category/create";
    }

    @PostMapping("/create")
    public String createSubCategoryForm(@Valid @ModelAttribute SubCategory subCategory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/sub_category/create";
        }
        subCategoryService.save(subCategory);
        return "redirect:/admin/sub-category";
    }

    @GetMapping("/edit/{id}")
    public String editSubCategoryForm(@PathVariable Long id, Model model) {
        SubCategory subCategory = subCategoryService.getSubCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại trang thiết bị có Id: " + id));
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("categories", categoryService.getAll());
        return "admin/sub_category/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateSubCategory(@PathVariable Long id, @Valid @ModelAttribute SubCategory subCategory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/sub_category/edit";
        }
        subCategory.setId(id);
        subCategoryService.save(subCategory);
        return "redirect:/admin/sub-category";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubCategory (@PathVariable Long id) {
        SubCategory subCategory = subCategoryService.getSubCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại trang thiết bị có Id" + id));
        subCategoryService.deleteById(id);
        return "redirect:/admin/sub-category";
    }
}
