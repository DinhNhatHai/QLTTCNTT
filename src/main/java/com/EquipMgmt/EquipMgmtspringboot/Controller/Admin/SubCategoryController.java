package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import com.EquipMgmt.EquipMgmtspringboot.Services.CategoryService;
import com.EquipMgmt.EquipMgmtspringboot.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/sub-category")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String index(Model model, @Param("keyword") String keyword) {
        List<SubCategory> list = this.subCategoryService.getAll();
        if (keyword != null) {
            list = this.subCategoryService.search(keyword);
        }
        model.addAttribute("listSubCategory", list);
        return "admin/sub_category/list";
    }


    @GetMapping("/create")
    public String add(Model model){
        SubCategory subCategory = new SubCategory();
        model.addAttribute("subCategory",subCategory);
        model.addAttribute("categories",categoryService.getAll());
        return "admin/sub_category/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("subCategory") SubCategory subCategory ){
        if(this.subCategoryService.create(subCategory)){
            return "admin/sub_category/create";
        }else {
            return "redirect:/admin/sub-category";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        SubCategory subCategory = subCategoryService.findById(id);
        List<Category> listCate = this.categoryService.getAll();
        model.addAttribute("subCategory",subCategory);
        model.addAttribute("listcate",listCate);

        return "admin/sub_category/edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("subCategory")SubCategory subCategory){
        if(this.subCategoryService.update(subCategory)){
            return "admin/sub_category/edit";
        }else {
            return "redirect:/admin/sub-category";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id){
        if(this.subCategoryService.delete(id)){
            return "redirect:/admin/sub-category";
        }else {
            return "redirect:/admin/sub-category";
        }
    }
}
